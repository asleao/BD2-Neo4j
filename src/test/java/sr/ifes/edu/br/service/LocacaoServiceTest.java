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
import sr.ifes.edu.br.bd2.CategoriaService;
import sr.ifes.edu.br.bd2.ClienteService;
import sr.ifes.edu.br.bd2.FilmeService;
import sr.ifes.edu.br.bd2.LocacaoService;
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Filme;
import sr.ifes.edu.br.bd2.domain.Locacao;
import sr.ifes.edu.br.bd2.domain.Sexo;
import sr.ifes.edu.br.bd2.util.datafactory.LocacaoData;

@ContextConfiguration(locations = "classpath:/spring/application-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocacaoServiceTest extends AbstractionTest{

	@Autowired
	private LocacaoService locacaoService;
        
        @Autowired 
        private ClienteService clienteService;
        
        @Autowired 
        private FilmeService filmeService;
        
        @Autowired
        private CategoriaService categoriaService;
        
        @Autowired
        private LocacaoData locacaoData;
	
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
            cleanUpGraph();
            long records = filmeService.getQuantidadeFilmes();
            assertNotNull(records);
            assertEquals(records, 0);
        }
        
        private Cliente criaCliente(){
            Cliente c = new Cliente();
            c.setDataNascimento(new Date());
            c.setNome("Moisés Omena");
            c.setSexo(Sexo.MASCULINO);
            return clienteService.criar(c);
        }
        
        private Categoria criaCategoria(){
            Categoria c = new Categoria(null, "Animação", 8.0);
            return categoriaService.criar(c);
        }
        
        private Filme criaFilme(){
            Filme f = new Filme();
            f.setDataCompra(new Date());
            f.setNome("Divertidamente");
            f.setPreco(21.0);
            f.setCategoria(criaCategoria());
            return filmeService.criar(f);
        }
        
        private Locacao criaLocacao(){
            Cliente c = criaCliente();
            Filme f = criaFilme();
            Locacao l = new Locacao(null, new Date(), new Date(), 0.0, f, c);
            return locacaoService.criar(l);
        }
        
	@Test
        public void shouldHaveZeroRecords(){
            long records = locacaoService.getQuantidadeLocacoes();
            assertNotNull(records);
            assertEquals(records, 0);
        }
        
        @Test
        public void shouldHaveAtLeastOneRecord(){
            criaLocacao();
            
            long records = locacaoService.getQuantidadeLocacoes();
            assertNotNull(records);
            assertTrue(records > 0);
        }
        
        @Test
        public void shouldFindLastInsertion(){
            Locacao expected = criaLocacao();
            assertNotNull(expected);
        }
        
        @Test
        public void shouldInsertHundredThousandRented(){
            int qtd = 100000;
            List<Locacao> expected = new ArrayList<>();
            for (int i = 0; i < qtd; i++) {
                expected.add(locacaoService.criar(locacaoData.build(df)));
            }
            
            assertNotNull(expected);
            assertEquals(expected.size(), qtd);
        }
	
}
