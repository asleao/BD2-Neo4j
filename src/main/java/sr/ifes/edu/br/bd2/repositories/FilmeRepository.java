package sr.ifes.edu.br.bd2.repositories;

import java.util.List;
import org.springframework.data.neo4j.repository.GraphRepository;
import sr.ifes.edu.br.bd2.domain.Filme;

public interface FilmeRepository extends GraphRepository<Filme> {
    List<Filme> findByNome(String nome);
}
