package loja.model.produto;

import java.math.BigDecimal;

public abstract class Produto {
    // definicao de atributos privados - encapsulamento
    private String codigoUnico;
    private String nome;
    private BigDecimal precoBase;
    //-----

    // construtores da classe
    public Produto() {  // construtor padrao
    }
    public Produto(String codigoUnico, String nome, BigDecimal precoBase) {  // construtor completo
		this.codigoUnico = codigoUnico;
		this.nome = nome;
		this.precoBase = precoBase;
	}
    //-----
    
    // getters
    public String getCodigoUnico() {  // codigoUnico
    	return codigoUnico;
    }
    public String getNome() {  // nome
    	return nome;
    }
    public BigDecimal getPrecoBase() {  // precoBase
    	return precoBase;
    }
    //-----
    
    // setters
    public void setPrecoBase(BigDecimal precoBase) {  // precoBase
    	this.precoBase = precoBase;
    }
    //-----
    
    // metodo abstrato do preco do produto
    public abstract BigDecimal calcularPrecoFinal();
    
    // definicao manual do toString
    public String toString() {
    	return String.format("%s - %s (R$ %.2f)", codigoUnico,nome,precoBase);
    }

}

