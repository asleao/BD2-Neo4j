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
import org.springframework.data.neo4j.annotation.GraphId;
import org.springframework.data.neo4j.annotation.NodeEntity;

/**
 *
 * @author breno
 */
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@NodeEntity
public class Categoria {
    
    @GraphId
    private Long id;
    
    private String descricao;
    private Double preco;

    @Override
    public String toString() {
        return "Categoria{" + "id:" + id + ", descricao:" + descricao + ", preco:" + preco + '}';
    }
}
