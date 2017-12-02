package net.unibave.ecommerce.pedido;

import net.unibave.ecommerce.cliente.Cliente;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedido")
@SequenceGenerator(name = "pedido_seq", sequenceName = "pedido_seq")
public class Pedido implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="pedido_seq")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente", nullable = false)
    private Cliente cliente;

    @Column(name = "data", nullable = false)
    private LocalDate data;

    @ElementCollection
    @CollectionTable(name="item_pedido", joinColumns={@JoinColumn(name="pedido_id")})
    private List<ItemPedido> itens;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pedido pedido = (Pedido) o;

        return id != null ? id.equals(pedido.id) : pedido.id == null;
    }


    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

}
