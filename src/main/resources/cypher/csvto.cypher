USING PERIODIC COMMIT LOAD CSV WITH HEADERS FROM "file:/tmp/categoria.csv" AS row 
CREATE (:Categoria {categoriaId: toInt(row.id), descricao: row.descricao, preco: toFloat(row.preco)}); 

USING PERIODIC COMMIT LOAD CSV WITH HEADERS FROM "file:/tmp/cliente.csv" AS row 
CREATE (:Cliente {clienteId: toInt(row.id), datanascimento: row.datanascimento, nome: row.nome, sexo: row.sexo});

USING PERIODIC COMMIT LOAD CSV WITH HEADERS FROM "file:/tmp/filme.csv" AS row 
CREATE (:Filme {filmeId: toInt(row.id), datacompra: row.datacompra, nome: row.nome, paisorigem: toInt(row.paisorigem), preco: toFloat(row.preco), categoriaId: toInt(row.categoria_id)});

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/tmp/filme.csv" AS row
MATCH (filme:Filme {filmeId: toInt(row.id)})
MATCH (categoria:Categoria {categoriaId: toInt(row.categoria_id)})
MERGE (filme)-[cla:CLASSIFICADO]->(categoria);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/tmp/filme.csv" AS row
MATCH (filme:Filme {filmeId: toInt(row.id)})
MATCH (categoria:Categoria {categoriaId: toInt(row.categoria_id)})
MERGE (filme)<-[cla:CLASSIFICA]-(categoria);

USING PERIODIC COMMIT
LOAD CSV WITH HEADERS FROM "file:/tmp/locacao.csv" AS row
MATCH (filme:Filme {filmeId: toInt(row.filme_id)})
MATCH (cliente:Cliente {clienteId: toInt(row.cliente_id)})
MERGE (cliente)-[loc:ALUGA]->(filme)
ON CREATE SET loc.locacaoId = toInt(row.id), loc.dataDevolucao = row.datadevolucao, loc.dataLocacao = row.datalocacao, loc.multa = toFloat(row.multa);


// Criando índices

CREATE INDEX ON :Filme(filmeId);
CREATE INDEX ON :Cliente(clienteId);
CREATE INDEX ON :Categoria(categoriaId);
CREATE INDEX ON :Locacao(locacaoId);
