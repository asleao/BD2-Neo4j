/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import org.fluttercode.datafactory.impl.DataFactory;

/**
 *
 * @author dred
 */
public class MainData {
 
    public static void main(String args[]){
        DataFactory df = new DataFactory();
        CategoriaData cat = new CategoriaData();
        ClienteData cli = new ClienteData();
        FilmeData fil = new FilmeData();
        LocacaoData loc = new LocacaoData();
        
        cat.criarCategoriaRandom(df,5);
        cli.criarClienteRandom(df, 5);
        fil.criarFilmeRandom(df, 5);
        loc.criarLocacaoRandom(df,5);
        
    }
}
