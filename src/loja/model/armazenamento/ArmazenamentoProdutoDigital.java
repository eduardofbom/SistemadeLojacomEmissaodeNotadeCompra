package src.loja.model.armazenamento;

import src.loja.model.produto.ProdutoDigital;

public class ArmazenamentoProdutoDigital extends Armazenamento {
    private ProdutoDigital[] produtos = new ProdutoDigital[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(ProdutoDigital produto) {
        if (produto == null || estaCheio()) return false;
        produtos[tamanho++] = produto;
        tamanhoAux++;
        return true;
    }
    
    public boolean remover(ProdutoDigital produto) {
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].equals(produto)) {
                System.arraycopy(produtos, i+1, produtos, i, tamanho-i-1);
                produtos[--tamanho] = null;
                return true;
            }
        }
        return false;
    }
    
    public ProdutoDigital buscarPorCodigo(String codigo) {
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].getCodigo().equals(codigo)) {
                return produtos[i];
            }
        }
        return null;
    }
   

    /*
    public ProdutoDigital[] listarTodos() {
        ProdutoDigital[] copia = new ProdutoDigital[tamanho];
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
}