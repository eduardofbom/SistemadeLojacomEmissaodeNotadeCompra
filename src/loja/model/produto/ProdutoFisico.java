package loja.model.produto;

import java.math.BigDecimal;

public class ProdutoFisico extends Produto {
	// definicao de atributos protected - encapsulamento
	protected double pesoKg;
	protected BigDecimal frete; 
    //-----

    // construtores da classe
    public ProdutoFisico() {  // construtor padrao
    }
    public ProdutoFisico(String codigo, String nome, BigDecimal preco, double pesoKg, BigDecimal frete) {  // construtor completo
    	super(codigo, nome, preco, 1);
    	this.pesoKg = pesoKg;
    	this.frete = frete;
    }
    //-----
    
    // getters
    public double getPesoKg() {
    	return pesoKg;
    }
    public BigDecimal getFrete() {
    	return frete;
    }    
    //-----
    
    // setters
    public void setPesoKg(double pesoKg) {
    	this.pesoKg = pesoKg;
    }
    public void setFrete(BigDecimal frete) {
    	this.frete = frete;
    }
    //-----
    

	// metodo especifico do preco do produto
    public BigDecimal calcularPrecoFinal() {
    	return (this.preco.add(this.frete));
    }
    
    // definicao manual do toString
    public String toString() {
    	return super.toString() + 
    			String.format(" (Peso: %.2fkg,  Frete: R$ %.2f)", this.pesoKg,this.frete);
    }
}
