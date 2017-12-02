package net.unibave.ecommerce.cliente;

import net.unibave.ecommerce.base.EntityId;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "cliente")
@SequenceGenerator(name = "cliente_seq", sequenceName = "cliente_seq")
public class Cliente implements Serializable, EntityId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="cliente_seq")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @Valid
    @Embedded
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        return id != null ? id.equals(cliente.id) : cliente.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", endereco=" + endereco +
                '}';
    }

}
