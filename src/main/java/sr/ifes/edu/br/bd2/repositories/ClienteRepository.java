package sr.ifes.edu.br.bd2.repositories;

import java.util.List;
import org.springframework.data.neo4j.repository.GraphRepository;
import sr.ifes.edu.br.bd2.domain.Cliente;

public interface ClienteRepository extends GraphRepository<Cliente> {
    List<Cliente> findByNome(String nome);
}
