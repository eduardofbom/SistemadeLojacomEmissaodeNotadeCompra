package src.loja.model.produto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ProdutoPerecivel extends ProdutoFisico {
	// definicao de atributos protected - encapsulamento
	protected LocalDate validade;
    //-----

    // construtores da classe
    public ProdutoPerecivel() {  // construtor padrao
    }
    public ProdutoPerecivel(String codigo, String nome, BigDecimal preco,  // construtor completo
    						double pesoKg, BigDecimal frete, LocalDate validade) {
    	super(codigo, nome, preco, pesoKg, frete);
    	super.tipo = 3;
    	this.validade = validade;
    }
    //-----
    
    // getters
    public double getPesoKg() {
    	return pesoKg;
    }
    public BigDecimal getFrete() {
    	return frete;
    }    
    public LocalDate getValidade() {
    	return validade;
    }
    //-----
    
	// setters
    public void setPesoKg(double pesoKg) {
    	this.pesoKg = pesoKg;
    }
    public void setFrete(BigDecimal frete) {
    	this.frete = frete;
    }
    public void setValidade(LocalDate validade) {
    	this.validade = validade;
    }    
    //-----
    

	// metodo especifico do preco do produto
    public BigDecimal calcularPrecoFinal() {
    	// desconto de 20% se estiver perto da validade
    	if (LocalDate.now().plusDays(7).isAfter(validade)) {
    		return super.calcularPrecoFinal().multiply(new BigDecimal("0.8")); // 20%
    	}
    	return super.calcularPrecoFinal();  // preco normal (base + frete
    }
    //-----
    
    // definicao manual do toString
    public String toString() {
    	return super.toString() + 
    			String.format(" (Validade: %s)", this.validade);
    }
    //-----
	
}
