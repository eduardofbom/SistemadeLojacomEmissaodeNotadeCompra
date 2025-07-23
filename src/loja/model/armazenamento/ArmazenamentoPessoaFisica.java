package loja.model.armazenamento;

import loja.model.armazenamento.Armazenamento;
import loja.model.cliente.PessoaFisica;

public class ArmazenamentoPessoaFisica extends Armazenamento {
    private PessoaFisica[] pessoas = new PessoaFisica[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(PessoaFisica pessoa) {
        if (pessoa == null || estaCheio()) return false;
        pessoas[tamanho++] = pessoa;
        this.tamanhoAux++;
        return true;
    }
    
    public boolean remover(PessoaFisica pessoa) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].equals(pessoa)) {
                System.arraycopy(pessoas, i+1, pessoas, i, tamanho-i-1);
                pessoas[--tamanho] = null;
                return true;
            }
        }
        return false;
    }
    
    public PessoaFisica buscarId(String id) {
        for (int i = 0; i < tamanhoAux; i++) {
        	if(pessoas[i] == null) {
        		
        	} else if (id.equalsIgnoreCase(pessoas[i].getId())) {
                return pessoas[i];
            }
        }
        return null;
    }
     
    public PessoaFisica buscarPorCpf(String cpf) {
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getCpf().equals(cpf)) {
                return pessoas[i];
            }
        }
        return null;
    }
    
    /*
    public PessoaFisica[] listarTodos() {
        PessoaFisica[] copia = new PessoaFisica[tamanho];
        System.arraycopy(pessoas, 0, copia, 0, tamanho);
        return copia;
    }
    */
    public void listarTodos() {
        for (int i=0; i<tamanhoAux; i++) {
        	if(pessoas[i] == null) {
        		
        	} else {        		
        		System.out.println(pessoas[i]);
        	}
        }
    }
    
    public PessoaFisica[] buscarPorNome(String nome) {
        int count = 0;
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getNome().contains(nome)) {
            	count++;
            }
        }
        
        PessoaFisica[] resultado = new PessoaFisica[count];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            if (pessoas[i].getNome().contains(nome)) {
                resultado[index++] = pessoas[i];
            }
        }
        return resultado;
    }
}