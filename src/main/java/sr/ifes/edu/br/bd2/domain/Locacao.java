/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.domain;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.annotation.Fetch;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;
import org.springframework.data.neo4j.annotation.RelatedTo;

/**
 *
 * @author breno
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NodeEntity
public class Locacao {
    
    @GraphId
    private Long id;
    
    private Date dataLocacao;
    private Date dataDevolucao;
    
    private Double multa;
    
    @Fetch @RelatedTo(type = "LOCACAO_FILME")
    private Filme filme;
    
    @Fetch @RelatedTo(type = "LOCACAO_CLIENTE")
    private Cliente cliente;
}
