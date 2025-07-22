package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto{
	// definicao de atributos protected - encapsulamento
	protected ;
	protected ;
    //-----

    // construtores da classe
    public ProdutoDigital() {  // construtor padrao
    }   
    public ProdutoDigital(String codigo, String nome, BigDecimal preco, int tipo, double pesoKg, BigDecimal frete) {
    // construtor completo
		super(codigo, nome, preco, tipo);
		this. = Kg;
		this. = ;
	}


	//-----
    
    // getterss
    
    //-----
    
    // setters
    
    //-----
    
    // metodo especifico do preco do produto
    public BigDecimal calcularPrecoFinal() {
    	
    }
    
    // definicao manual do toString
    public String toString() {
    	return super.toString() + 
    	String.format("", );
    }
}
