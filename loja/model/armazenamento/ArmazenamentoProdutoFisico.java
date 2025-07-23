package loja.model.armazenamento;

import loja.model.produto.ProdutoFisico;
import java.math.BigDecimal;

public class ArmazenamentoProdutoFisico extends Armazenamento {
    private ProdutoFisico[] produtos = new ProdutoFisico[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(ProdutoFisico produto) {
        if (produto == null || estaCheio()) return false;
        produtos[tamanho++] = produto;
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
    public boolean atualizar(String codigo, ProdutoFisico novosDados) {
        ProdutoFisico existente = buscarPorCodigo(codigo);
        if (existente != null) {
            existente.setNome(novosDados.getNome());
            existente.setPreco(novosDados.getPreco());
            existente.setPesoKg(novosDados.getPesoKg());
            existente.setFrete(novosDados.getFrete());
            return true;
        }
        return false;
    }
    */
    
    public ProdutoFisico[] listarTodos() {
        ProdutoFisico[] copia = new ProdutoFisico[tamanho];
        System.arraycopy(produtos, 0, copia, 0, tamanho);
        return copia;
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