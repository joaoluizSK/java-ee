package net.unibave.ecommerce.pedido;

import net.unibave.ecommerce.produto.Produto;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
public class ItemPedido {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="item_pedido_seq")
//    @Column(name = "id")
//    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto", nullable = false)
    private Produto produto;

    @Column(name = "preco_unitario", precision = 12, scale = 2, nullable = false)
    private BigDecimal precoUnitario;

    @Column(name = "quantidade", precision = 12, scale = 2, nullable = false)
    private BigDecimal quantidade;

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public BigDecimal getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(BigDecimal quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "ItemPedido{" +
                "produto=" + produto +
                ", precoUnitario=" + precoUnitario +
                ", quantidade=" + quantidade +
                '}';
    }
}
