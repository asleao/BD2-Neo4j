/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import java.util.Date;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sr.ifes.edu.br.bd2.domain.Filme;

/**
 *
 * @author dred
 */
@Service
public class FilmeData {
    
    @Autowired
    private CategoriaData categoriaData;
    
    public Filme build(DataFactory df){
        
        Filme filme = new Filme();
        filme.setNome("Filme "+df.getRandomWord());
        filme.setPreco(new Double(df.getNumberBetween(2, 70)));
        filme.setCategoria(categoriaData.criarCategoria(df));
        filme.setDataCompra(df.getDateBetween(df.getDate(1960, 1, 1),
                                              new Date()));
        return filme;
    }
    
}

