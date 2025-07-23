package src.loja.model.armazenamento;

import src.loja.model.cliente.PessoaJuridica;

public class ArmazenamentoPessoaJuridica extends Armazenamento {
    private PessoaJuridica[] empresas = new PessoaJuridica[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(PessoaJuridica empresa) {
        if (empresa == null || estaCheio()) return false;
        empresas[tamanho++] = empresa;
        tamanhoAux++;
        return true;
    }
    
    public boolean remover(PessoaJuridica empresa) {
        for (int i = 0; i < tamanho; i++) {
            if (empresas[i].equals(empresa)) {
                System.arraycopy(empresas, i+1, empresas, i, tamanho-i-1);
                empresas[--tamanho] = null;
                return true;
            }
        }
        return false;
    }
    
    public PessoaJuridica buscarPorCnpj(String cnpj) {
        for (int i = 0; i < tamanho; i++) {
            if (empresas[i].getCnpj().equals(cnpj)) {
                return empresas[i];
            }
        }
        return null;
    }    
    
    /*
    public PessoaJuridica[] listarTodos() {
        PessoaJuridica[] copia = new PessoaJuridica[tamanho];
        System.arraycopy(empresas, 0, copia, 0, tamanho);
        return copia;
    }
    */

    public void listarTodos() {
        for (int i=0; i<tamanhoAux; i++) {
        	if(empresas[i] == null) {
        		
        	} else {        		
        		System.out.println(empresas[i]);
        	}
        }
    }
}