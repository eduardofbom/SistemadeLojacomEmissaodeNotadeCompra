package src.loja.model.armazenamento;

import src.loja.model.produto.ProdutoFisico;
// import java.math.BigDecimal;

public class ArmazenamentoProdutoFisico extends Armazenamento {
    private ProdutoFisico[] produtos = new ProdutoFisico[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(ProdutoFisico produto) {
        if (produto == null || estaCheio()) return false;
        produtos[tamanho++] = produto;
        tamanhoAux++;
        return true;
    }
    
    public boolean remover(ProdutoFisico produto) {
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].equals(produto)) {
                System.arraycopy(produtos, i+1, produtos, i, tamanho-i-1);
                produtos[--tamanho] = null;
                return true;
            }
        }
        return false;
    }
    
    public ProdutoFisico buscarPorCodigo(String codigo) {
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].getCodigo().equals(codigo)) {
                return produtos[i];
            }
        }
        return null;
    }
    

    /*
    public ProdutoFisico[] listarTodos() {
        ProdutoFisico[] copia = new ProdutoFisico[tamanho];
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
    
    public ProdutoFisico[] listarPorPesoMinimo(double pesoMinimo) {
        int count = 0;
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].getPesoKg() >= pesoMinimo) count++;
        }
        
        ProdutoFisico[] resultado = new ProdutoFisico[count];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            if (produtos[i].getPesoKg() >= pesoMinimo) {
                resultado[index++] = produtos[i];
            }
        }
        return resultado;
    }
    
}