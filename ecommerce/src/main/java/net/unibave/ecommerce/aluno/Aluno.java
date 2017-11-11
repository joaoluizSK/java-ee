package net.unibave.ecommerce.aluno;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@Builder
@AllArgsConstructor
public class Aluno implements Serializable {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private String nome;

    @Column
    private String cidade;

}
