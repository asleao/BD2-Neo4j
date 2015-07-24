package sr.ifes.edu.br.bd2.repositories;

import sr.ifes.edu.br.bd2.domain.World;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface WorldRepository extends GraphRepository<World> {}
