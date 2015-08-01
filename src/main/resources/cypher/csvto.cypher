USING PERIODIC COMMIT LOAD CSV WITH HEADERS FROM "file:/tmp/categoria.csv" AS row CREATE (:Categoria {categoriaId: row.id, descricao: row.descricao, preco: row.preco}); 

USING PERIODIC COMMIT LOAD CSV WITH HEADERS FROM "file:/tmp/cliente.csv" AS row CREATE (:Cliente {clienteId: row.id, datanascimento: row.datanascimento, nome: row.nome, sexo: row.sexo});

USING PERIODIC COMMIT LOAD CSV WITH HEADERS FROM "file:/tmp/filme.csv" AS row CREATE (:Filme {filmeId: row.id, datacompra: row.datacompra, nome: row.nome, paisorigem: row.paisorigem, preco: row.preco, categoriaId: row.categoria_id});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/tmp/filme.csv" AS row
MATCH (filme:Filme {filmeId: row.id})
MATCH (categoria:Categoria {categoriaId: row.categoria_id})
MERGE (filme)-[cla:CLASSIFICADO]->(categoria);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/tmp/locacao.csv" AS row
MATCH (filme:Filme {filmeId: row.filme_id})
MATCH (cliente:Cliente {clienteId: row.cliente_id})
MERGE (cliente)-[loc:ALUGA]->(filme)
ON CREATE SET loc.locacaoId = row.id, loc.dataDevolucao = row.datadevolucao, loc.dataLocacao = row.datalocacao, loc.multa = row.multa;