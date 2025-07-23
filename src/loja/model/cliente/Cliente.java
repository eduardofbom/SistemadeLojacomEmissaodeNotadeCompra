package src.loja.model.cliente;

public abstract class Cliente {
	// definicao de atributos protected - encapsulamento
	protected String id;
    protected String nome;
    protected String endereco;
    protected String telefone;
    //-----
    
    // construtores da classe
    public Cliente() {  // construtor padrao
    }
    public Cliente(String id, String nome, String endereco, String telefone) {  // construtor completo
		this.id = id;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
	}
	//-----
    
    // getters
    public String getId() {
    	return id;
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
    	return String.format("ID: %s NOME: %s TEL: %s END: %s", this.id, this.nome, this.telefone, this.endereco);
    }
	
}