/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.util.datafactory;

import java.util.Date;
import java.util.List;
import org.fluttercode.datafactory.impl.DataFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sr.ifes.edu.br.bd2.domain.Cliente;
import sr.ifes.edu.br.bd2.domain.Filme;
import sr.ifes.edu.br.bd2.domain.Locacao;
import sr.ifes.edu.br.bd2.repositories.ClienteRepository;
import sr.ifes.edu.br.bd2.repositories.FilmeRepository;
import sr.ifes.edu.br.bd2.repositories.LocacaoRepository;

/**
 *
 * @author dred
 */
@Service
public class LocacaoData {
    @Autowired
    private LocacaoRepository locacaoRepository;
    @Autowired
    private ClienteRepository clienteRepository;
    @Autowired
    private FilmeRepository filmeRepository;
    
    
    public void criarLocacaoRandom(DataFactory df, int qtdLoc){
        for (int i = 0; i < qtdLoc; i++) {
            salvarLocacao(criarLocacao(df));
        }
    }
    
    public Locacao criarLocacao(DataFactory df){
        Locacao locacao = new Locacao();
        Date dataDevolucao = new Date();
        
        int diasAmais = df.getNumberBetween(5, 15);
        
        locacao.setCliente(df.getItem((List<Cliente>)clienteRepository.findAll()));
        locacao.setFilme(df.getItem((List<Filme>)filmeRepository.findAll()));
        locacao.setDataLocacao(df.getDateBetween(df.getDate(1960, 1, 1),
                                              df.getDate(2015, 8, 1)));
        dataDevolucao.setDate(locacao.getDataLocacao().getDate()+ diasAmais);
        locacao.setDataDevolucao(dataDevolucao);
        
        if(diasAmais > 5){
            locacao.setMulta(new Double(((diasAmais-5)*2)));
        }
        
        return locacao;
    }
    
    public void salvarLocacao(Locacao locacao){
        try {
            locacaoRepository.save(locacao);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
}
