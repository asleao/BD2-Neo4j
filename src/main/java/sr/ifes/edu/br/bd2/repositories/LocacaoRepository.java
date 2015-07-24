package sr.ifes.edu.br.bd2.repositories;

import org.springframework.data.neo4j.repository.GraphRepository;
import sr.ifes.edu.br.bd2.domain.Locacao;

public interface LocacaoRepository extends GraphRepository<Locacao> {}
