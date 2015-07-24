package sr.ifes.edu.br.bd2.repositories;

import java.util.List;
import org.springframework.data.neo4j.repository.GraphRepository;
import sr.ifes.edu.br.bd2.domain.Categoria;

public interface CategoriaRepository extends GraphRepository<Categoria> {
    List<Categoria> findByDescricao(String descricao);
}
