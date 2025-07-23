package src.loja.model.armazenamento;

import src.loja.model.produto.ProdutoPerecivel;
import java.time.LocalDate;

public class ArmazenamentoProdutoPerecivel extends Armazenamento {
    private ProdutoPerecivel[] produtos = new ProdutoPerecivel[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(ProdutoPerecivel produto) {
        if (produto == null || estaCheio()) return false;
        produtos[tamanho++] = produto;
        tamanhoAux++;
        return true;
    }
    
    public boolean remover(ProdutoPerecivel produto) {
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].equals(produto)) {
                System.arraycopy(produtos, i+1, produtos, i, tamanho-i-1);
                produtos[--tamanho] = null;
                return true;
            }
        }
        return false;
    }
    
    public ProdutoPerecivel buscarPorCodigo(String codigo) {
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].getCodigo().equals(codigo)) {
                return produtos[i];
            }
        }
        return null;
    }
    
    
    /*
    public ProdutoPerecivel[] listarTodos() {
        ProdutoPerecivel[] copia = new ProdutoPerecivel[tamanho];
        System.arraycopy(produtos, 0, copia, 0, tamanho);
        return copia;
    }
    */
    public void listarTodos() {
        for (int i=0; i<tamanhoAux; i++) {
        	if(produtos[i] == null) {
        		
        	} else {        		
        		System.out.println(produtos[i]);
        	}
        }
    }
    
    public ProdutoPerecivel[] listarProximosVencimento(int dias) {
        LocalDate limite = LocalDate.now().plusDays(dias);
        int count = 0;
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].getValidade().isBefore(limite)) count++;
        }
        
        ProdutoPerecivel[] resultado = new ProdutoPerecivel[count];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].getValidade().isBefore(limite)) {
                resultado[index++] = produtos[i];
            }
        }
        return resultado;
    }
}