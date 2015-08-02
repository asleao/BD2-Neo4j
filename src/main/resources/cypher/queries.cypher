//Q1

MATCH (c:Cliente)-[l:ALUGA]->(f:Filme)-[cla:CLASSIFICADO]->(cat:Categoria)
WHERE f.preco > 60 AND c.nome =~ "^.*an.*$" AND cat.descricao <> "Aventura"
RETURN c.clienteId, c.nome, count(c);

//Q2

MATCH (c:Cliente)-[l:ALUGA]->(f:Filme)-[cla:CLASSIFICADO]->(cat:Categoria)
RETURN cat.descricao, SUM(cat.preco);

//Q3

MATCH (c:Cliente)-[l:ALUGA]->(f:Filme)-[cla:CLASSIFICADO]->(cat:Categoria)
WHERE cat.categoriaId IN [1, 2] AND c.sexo = "1"
RETURN c.clienteId, c.nome, c.sexo, f.nome, cat.descricao

//Q4

MATCH (c:Cliente)-[l:ALUGA]->(f:Filme)-[cla:CLASSIFICADO]->(cat:Categoria)
WHERE cat.categoriaId IN [1, 2] AND c.sexo = "1"
RETURN c, l, f, cla, cat;

//Q5

MATCH (sF:Filme)-[sCla:CLASSIFICADO]->(sCat:Categoria) WHERE sCat.descricao <> "Aventura"
WITH DISTINCT sCat, sF, sCla
MATCH (c:Cliente)-[l:ALUGA]->(sF)
WHERE c.sexo = "1"
RETURN c, l, sF, sCla, sCat;

//Custom 1

MATCH (c:Cliente)-[r:ALUGA]->(f:Filme)-[cla:CLASSIFICADO]->(cat:Categoria) WHERE cat.descricao =~ ".*a.*"
WITH DISTINCT c
MATCH (c)-[r:ALUGA]-(f:Filme)
RETURN c;

//Custom 2

MATCH (c:Cliente)-[l:ALUGA]->(f:Filme)-[cla:CLASSIFICADO]->(cat:Categoria)
RETURN cat.descricao
