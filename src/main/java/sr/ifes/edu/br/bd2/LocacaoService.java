package sr.ifes.edu.br.bd2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sr.ifes.edu.br.bd2.domain.Locacao;
import sr.ifes.edu.br.bd2.repositories.LocacaoRepository;

@Service
@Transactional
public class LocacaoService {
	
	@Autowired
	public LocacaoRepository locacaoRepository;
	
	public long getQuantidadeLocacoes(){
            return locacaoRepository.count();
        }
        
        public Locacao criar(Locacao locacao){
            return locacaoRepository.save(locacao);
        }
}
