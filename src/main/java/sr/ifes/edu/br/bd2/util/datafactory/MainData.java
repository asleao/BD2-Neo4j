/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author dred
 */
public class MainData {
 
    public static void main(String args[]){
        
         ApplicationContext context = new FileSystemXmlApplicationContext(
                "src/main/resources/spring/application-context.xml");

        BeanFactory factory = context;
        
        DataFactory df = new DataFactory();
        df.randomize((int) System.currentTimeMillis());
        
        
        
        CategoriaData cat = (CategoriaData) factory.getBean("categoriaData");
        ClienteData cli = (ClienteData) factory.getBean("clienteData");
        FilmeData fil = (FilmeData) factory.getBean("filmeData");
        LocacaoData loc = (LocacaoData) factory.getBean("locacaoData");
        
        cat.criarCategoriaRandom(df,5);
        cli.criarClienteRandom(df, 5);
        fil.criarFilmeRandom(df, 5);
        loc.criarLocacaoRandom(df,5);
        
    }
}
