package sr.ifes.edu.br.service;

import java.util.Date;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.support.Neo4jTemplate;
import org.springframework.data.neo4j.support.node.Neo4jHelper;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.BeforeTransaction;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;
import org.junit.Before;
import sr.ifes.edu.br.bd2.FilmeService;
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.domain.Filme;

@ContextConfiguration(locations = "classpath:/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class FilmeServiceTest {

	@Autowired
	private FilmeService filmeService;
	
	@Autowired
	private Neo4jTemplate template;
	
	@Rollback(false)
	@BeforeTransaction
        @Before
	public void cleanUpGraph() {
            Neo4jHelper.cleanDb(template);
	}
	
	@Test
        public void shouldHaveZeroRecords(){
            cleanUpGraph();
            long records = filmeService.getQuantidadeFilmes();
            assertNotNull(records);
            assertEquals(records, 0);
        }
        
        @Test
        public void shouldHaveAtLeastOneRecord(){
            Filme f = new Filme();
            f.setDataCompra(new Date());
            f.setNome("Divertidamente");
            f.setPreco(21.0);
            Categoria c = new Categoria(null, "Animação", 8.0);
            f.setCategoria(c);
            filmeService.criar(f);
            long records = filmeService.getQuantidadeFilmes();
            assertNotNull(records);
            assertTrue(records > 0);
        }
        
        @Test
        public void shouldFindLastInsertion(){
            Filme f = new Filme();
            f.setDataCompra(new Date());
            f.setNome("Divertidamente");
            f.setPreco(21.0);
            Categoria c = new Categoria(null, "Animação", 8.0);
            f.setCategoria(c);
            Filme expected = filmeService.criar(f);
            assertNotNull(expected);
        }
	
}
