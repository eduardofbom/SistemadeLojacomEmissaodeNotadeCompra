package loja;

import loja.model.cliente.Cliente;

public class Main {
    public static void main(String[] args) {
    	Cliente p = new Cliente("001","Fulano da Silva","Rua A, 123 - Bairro B","99988776655");
    	
    	System.out.println();
    	System.out.println(p.getIdUnico());
    	System.out.println(p.getNome());
    	System.out.println(p.getEndereco());
    	System.out.println(p.getTelefone());
    	System.out.println(p);
    	System.out.println();
    	
    	p.setEndereco("Rua X, 789 - Bairro Y");
    	System.out.println(p.getEndereco());
    	System.out.println(p);
    	System.out.println();
    	
    	p.setTelefone("44433221100");
    	System.out.println(p.getTelefone());
    	System.out.println(p);
    }
}









// definicao de atributos privados - encapsulamento

//-----

// construtores da classe

//-----

// getters

//-----

// setters

//-----

// metodos

// definicao manual do toString

//-----