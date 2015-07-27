/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.stereotype.Service;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Sexo;

/**
 *
 * @author dred
 */
@Service
public class ClienteData {
    
    public Cliente build(DataFactory df){
        Cliente cliente = new Cliente();
        cliente.setNome(df.getName());
        cliente.setDataNascimento(df.getBirthDate());
        cliente.setSexo(df.getItem(Sexo.values()));
        
        return cliente;
    }
}
