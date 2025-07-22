package loja.model.produto;

import java.math.BigDecimal;

public abstract class Produto {
    // definicao de atributos privados - encapsulamento
    protected String codigo;
    protected String nome;
    protected BigDecimal preco;
    protected int tipo;
    //-----

    // construtores da classe
    public Produto() {  // construtor padrao
    }
    public Produto(String codigo, String nome, BigDecimal preco, int tipo) {  // construtor completo
		this.codigo = codigo;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
	}
    //-----
    
    // getterss
    public String getCodigo() {  // codigoUnico
    	return this.codigo;
    }
    public String getNome() {  // nome
    	return this.nome;
    }
    public BigDecimal getPreco() {  // precoBase
    	return this.preco;
    }
    public int getTipo() {  // tipo
    	return this.tipo;
    }
    //-----
    
    // setters
    public void setPreco(BigDecimal preco) {  // precoBase
    	this.preco = preco;
    }
    //-----
    
    // metodo abstrato do preco do produto
    public abstract BigDecimal calcularPrecoFinal();
    
    // definicao manual do toString
    public String toString() {
    	return String.format("[%s] %s (R$ %.2f)", codigo,nome,preco);
    }

}

