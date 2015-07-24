package sr.ifes.edu.br.bd2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sr.ifes.edu.br.bd2.domain.Filme;
import sr.ifes.edu.br.bd2.repositories.FilmeRepository;

@Service
@Transactional
public class FilmeService {
	
	@Autowired
	public FilmeRepository filmeRepository;
	
	public long getQuantidadeFilmes(){
            return filmeRepository.count();
        }
        
        public Filme criar(Filme filme){
            return filmeRepository.save(filme);
        }
}
