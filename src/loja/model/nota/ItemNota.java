package src.loja.model.nota;

import src.loja.model.produto.Produto;
import java.math.BigDecimal;

public class ItemNota {
    private Produto produto;
    private int quantidade;
    private BigDecimal precoUnitario;

    public ItemNota(Produto produto, int quantidade) {
        if (produto == null) {
            throw new IllegalArgumentException("Produto não pode ser nulo");
        }
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = produto.calcularPrecoFinal();
    }

    public BigDecimal calcularTotal() {
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }

    // Getters
    public Produto getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }

    // Setters com validação
    public void setQuantidade(int quantidade) {
        if (quantidade <= 0) {
            throw new IllegalArgumentException("Quantidade deve ser maior que zero");
        }
        this.quantidade = quantidade;
    }

    public String toString() {
        return String.format("%d x %s - %s (R$ %.2f) = R$ %.2f",
                quantidade,
                produto.getCodigo(),
                produto.getNome(),
                precoUnitario,
                calcularTotal());
    }
}