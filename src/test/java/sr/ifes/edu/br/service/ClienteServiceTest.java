package sr.ifes.edu.br.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import sr.ifes.edu.br.bd2.ClienteService;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Sexo;
import sr.ifes.edu.br.bd2.util.datafactory.ClienteData;

@ContextConfiguration(locations = "classpath:/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ClienteServiceTest extends AbstractionTest{

	@Autowired
	private ClienteService clienteService;
        
        @Autowired
        private ClienteData clienteData;
	
	@Autowired
	private Neo4jTemplate template;
	
	@Rollback(false)
	@BeforeTransaction
        @Before
	public void cleanUpGraph() {
            Neo4jHelper.cleanDb(template);
	}
        
        /**
         * Esse nome é uma gambiarra necessária para estabelecer uma ordem na execução dos testes
         * Já que o setUp do banco demora um pouco, o tempo do teste é alterado.
         */
	@Test
        public void aaa1TheFirstTest(){
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
        
        @Test
        public void shoudInsertTenThousandOfClients(){
            int qtd = 10000;
            List<Cliente> expected = new ArrayList<>();
            for (int i = 0; i < qtd; i++) {
                expected.add(clienteService.criar(clienteData.build(df)));
            }
            assertNotNull(expected);
            assertEquals(expected.size(), qtd);
        }
	
}
