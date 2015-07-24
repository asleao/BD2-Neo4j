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
import sr.ifes.edu.br.bd2.ClienteService;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Sexo;

@ContextConfiguration(locations = "classpath:/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class ClienteServiceTest {

	@Autowired
	private ClienteService clienteService;
	
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
            long records = clienteService.getQuantidadeClientes();
            assertNotNull(records);
            assertEquals(records, 0);
        }
        
        @Test
        public void shouldHaveAtLeastOneRecord(){
            Cliente c = new Cliente();
            c.setDataNascimento(new Date());
            c.setNome("Moisés Omena");
            c.setSexo(Sexo.MASCULINO);
            clienteService.criar(c);
            long records = clienteService.getQuantidadeClientes();
            assertNotNull(records);
            assertTrue(records > 0);
        }
        
        @Test
        public void shouldFindLastInsertion(){
            Cliente c = new Cliente();
            c.setDataNascimento(new Date());
            c.setNome("Moisés Omena");
            c.setSexo(Sexo.MASCULINO);
            Cliente expected = clienteService.criar(c);
            assertNotNull(expected);
        }
	
}
