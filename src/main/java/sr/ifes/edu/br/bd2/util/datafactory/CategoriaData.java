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
import sr.ifes.edu.br.bd2.domain.Categoria;
import sr.ifes.edu.br.bd2.repositories.CategoriaRepository;

/**
 *
 * @author dred
 */
public class CategoriaData {
    
    @Autowired
    private CategoriaRepository categoriaRepository;
    
    public void criarCategoriaRandom(DataFactory df,int qtdCat){
        for (int i = 0; i < qtdCat; i++) {
            salvarCategoria(criarCategoria(df));
        }
    }
    
    public Categoria criarCategoria(DataFactory df){
        Categoria categoria = new Categoria();
        
        
        categoria.setDescricao(df.getItem(getCategorias()));
        categoria.setPreco(new Double(df.getNumberBetween(1, 50)));        
        
        return categoria;
    }
    
    public void salvarCategoria(Categoria categoria){
        try {
            categoriaRepository.save(categoria);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    private List<String> getCategorias(){
        List<String> listaCategorias = new ArrayList();
        
        listaCategorias.add("Terror");
        listaCategorias.add("Ação");
        listaCategorias.add("Suspense");
        listaCategorias.add("Drama");
        listaCategorias.add("Comédia");
        listaCategorias.add("Aventura");
        listaCategorias.add("Ficção Cientifica");
        listaCategorias.add("Guerra");
        listaCategorias.add("Romance");
        listaCategorias.add("Épico");
        listaCategorias.add("Musical");
        
        return listaCategorias;
    }
}
