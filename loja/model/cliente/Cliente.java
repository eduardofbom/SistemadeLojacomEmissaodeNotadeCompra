package loja.model.cliente;

import java.math.BigDecimal;

public abstract class Cliente {
	// definicao de atributos protected - encapsulamento
	protected String idUnico;
    protected String nome;
    protected String endereco;
    protected String telefone;
    //-----
    
    // construtores da classe
    public Cliente() {  // construtor padrao
    }
    public Cliente(String idUnico, String nome, String endereco, String telefone) {  // construtor completo
		this.idUnico = idUnico;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	//-----
    
    // getters
    public String getIdUnico() {
    	return idUnico;
    }
    public String getNome() {
    	return nome;
    }
    public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
    //-----
    
    // setters
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
    
    //-----
    
    // definicao manual do toString
    public String toString() {
    	return String.format("%s - %s", idUnico, nome);
    }
	
}