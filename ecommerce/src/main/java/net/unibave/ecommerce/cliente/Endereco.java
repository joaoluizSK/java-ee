package net.unibave.ecommerce.cliente;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

@Embeddable
public class Endereco {

    @NotNull
    @Column(name = "rua", length = 100, nullable = false)
    private String rua;

    @NotNull
    @Column(name = "cidade", length = 100, nullable = false)
    private String cidade;

    public String getRua() {
        return rua;
    }

    public void setRua(String endereco) {
        this.rua = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "endereco='" + rua + '\'' +
                ", cidade='" + cidade + '\'' +
                '}';
    }
}
