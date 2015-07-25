/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import java.util.ArrayList;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Sexo;
import sr.ifes.edu.br.bd2.repositories.ClienteRepository;

/**
 *
 * @author dred
 */
public class ClienteData {
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    public void criarClienteRandom(DataFactory df,int qtdCli){
        for (int i = 0; i < qtdCli; i++) {
            salvarCliente(criarCliente(df));
        }
    
    }
    
    public Cliente criarCliente(DataFactory df){
        Cliente cliente = new Cliente();
        List<Sexo> listaSexo = getListaSexo();
        
        cliente.setNome(df.getName());
        cliente.setDataNascimento(df.getBirthDate());
        cliente.setSexo(df.getItem(listaSexo));
        
        return cliente;
    }
    
    public void salvarCliente(Cliente cliente){
        try {
            clienteRepository.save(cliente);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private List<Sexo> getListaSexo(){
        List<Sexo> listaSexo = new ArrayList();
       
        listaSexo.add(Sexo.MASCULINO);
        listaSexo.add(Sexo.FEMININO);
        listaSexo.add(Sexo.OUTROS);
        
        return listaSexo;
    }
}
