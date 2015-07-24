package sr.ifes.edu.br.bd2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sr.ifes.edu.br.bd2.domain.Cliente;

import sr.ifes.edu.br.bd2.repositories.ClienteRepository;

@Service
@Transactional
public class ClienteService {
	
	@Autowired
	public ClienteRepository clienteRepository;
	
	public long getQuantidadeClientes(){
            return clienteRepository.count();
        }
        
        public Cliente criar(Cliente cliente){
            return clienteRepository.save(cliente);
        }
}
