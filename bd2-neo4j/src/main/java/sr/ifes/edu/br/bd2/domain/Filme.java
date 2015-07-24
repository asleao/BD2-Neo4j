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
public class Filme {
    
    @GraphId
    private Long id;
    
    private String nome;
    private Date dataCompra;
    private Double preco;
    
    @Fetch @RelatedTo(type = "FILME_CATEGORIA")
    private Categoria categoria;
}
