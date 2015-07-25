/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.domain.Filme;
import sr.ifes.edu.br.bd2.repositories.CategoriaRepository;
import sr.ifes.edu.br.bd2.repositories.FilmeRepository;

/**
 *
 * @author dred
 */
@Service
public class FilmeData {
    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public void criarFilmeRandom(DataFactory df, int qtdFil){
        for (int i = 0; i < qtdFil; i++) {
            salvarFilme(criarFilme(df));
        }
    }
    
    public Filme criarFilme(DataFactory df){
        Filme filme = new Filme();
        CategoriaData categoriaData = new CategoriaData();
        
        filme.setNome("Filme "+df.getRandomWord());
        filme.setPreco(new Double(df.getNumberBetween(2, 70)));
        filme.setCategoria(df.getItem((List<Categoria>)categoriaRepository.findAll()));
        filme.setDataCompra(df.getDateBetween(df.getDate(1960, 1, 1),
                                              df.getDate(2015, 8, 1)));
        return filme;
    }
    public void salvarFilme(Filme filme){
        try {
            filmeRepository.save(filme);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}

