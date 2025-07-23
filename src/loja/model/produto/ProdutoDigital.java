package src.loja.model.produto;

import java.math.BigDecimal;

public class ProdutoDigital extends Produto{
	// definicao de atributos protected - encapsulamento
	protected double tamanhoMb;
	protected String linkDownload;
    //-----

    // construtores da classe
    public ProdutoDigital() {  // construtor padrao
    }   
    public ProdutoDigital(String codigo, String nome, BigDecimal preco, double tamanhoMb, String linkDownload) {  // construtor completo
		super(codigo, nome, preco, 2);
		this.tamanhoMb = tamanhoMb;
		this.linkDownload = linkDownload;
	}
	//-----
    
    // getters
    public double getTamanhoMb() {
    	return this.tamanhoMb;
    }
    public String getLinkDownload() {
    	return this.linkDownload;
    }
    //-----
    
    // setters
    public void setTamanhoMb(double tamanhoMb) {
    	this.tamanhoMb = tamanhoMb;
    }
    public void setLinkDownload(String linkDownload) {
    	this.linkDownload = linkDownload;
    }
    //-----
    
    // metodo especifico do preco do produto
    public BigDecimal calcularPrecoFinal() {
    	return this.preco;
    }
    //-----
    
    // definicao manual do toString
	public String toString() {
    	return super.toString() + 
    	String.format(" (Tamanho: %.2fMB, Download %s)", this.tamanhoMb, this.linkDownload);
    }
	//-----
}
