package loja.model.nota;

import loja.model.produto.Produto;
import java.math.BigDecimal;

public class ItemNota {
    
	// definicao de atributos privados - encapsulamento
	private Produto produto;
    private int quantidade;
    private BigDecimal precoUnitario;
    //-----

    // construtores da classe
    public ItemNota() {}  // construtor padrao
    public ItemNota(Produto produto, int quantidade, BigDecimal precoUnitario) {  // construtor completo
		this.produto = produto;
		this.quantidade = quantidade;
		this.precoUnitario = produto.calcularPrecoFinal();
	}
    //-----
    
    // getters
    public Produto getProduto() {
    	return produto;
    }
    public int getQuantidade() {
    	return quantidade;
    }
    public BigDecimal getPrecoUnitario() {
    	return precoUnitario;
    }
    //-----
    
    // setters    
    public void setQuantidade(int quantidade) {
    	this.quantidade = quantidade;
    }
    //-----
    
    // metodos
    
    // definicao manual do toString
    
    //-----
}
