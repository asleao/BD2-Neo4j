/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.annotation.EndNode;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.RelationshipEntity;
import org.springframework.data.neo4j.annotation.StartNode;

/**
 *
 * @author breno
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@RelationshipEntity (type = "LOCACAO_FILME")
public class LocacaoFilmeRelationship {
    
    @GraphId Long id;
    
    private String description;
    
    @StartNode 
    private Locacao Locacao;
    
    @EndNode
    private Filme filme;
}
