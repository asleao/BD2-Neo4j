/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sr.ifes.edu.br.bd2.domain;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 *
 * @author breno
 */
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Data
@NodeEntity
@ToString

public class Cliente {
    
    @GraphId
    private Long id;
    
    private String nome;
    private Date dataNascimento;
    private Sexo sexo;
}
