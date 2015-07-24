package sr.ifes.edu.br.bd2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.repositories.CategoriaRepository;

@Service
@Transactional
public class CategoriaService {
	
	@Autowired
	public CategoriaRepository categoriaRepository;
	
	public long getQuantidadeCategorias(){
            return categoriaRepository.count();
        }
        
        public Categoria criar(Categoria categoria){
            return categoriaRepository.save(categoria);
        }
}
