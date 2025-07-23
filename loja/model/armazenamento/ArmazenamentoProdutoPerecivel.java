package loja.model.armazenamento;

import loja.model.produto.ProdutoPerecivel;
import java.time.LocalDate;

public class ArmazenamentoProdutoPerecivel extends Armazenamento {
    private ProdutoPerecivel[] produtos = new ProdutoPerecivel[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(ProdutoPerecivel produto) {
        if (produto == null || estaCheio()) return false;
        produtos[tamanho++] = produto;
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
    public boolean atualizar(String codigo, ProdutoPerecivel novosDados) {
        ProdutoPerecivel existente = buscarPorCodigo(codigo);
        if (existente != null) {
            existente.setNome(novosDados.getNome());
            existente.setPreco(novosDados.getPreco());
            existente.setPesoKg(novosDados.getPesoKg());
            existente.setFrete(novosDados.getFrete());
            existente.setValidade(novosDados.getValidade());
            return true;
        }
        return false;
    }
    */
    
    public ProdutoPerecivel[] listarTodos() {
        ProdutoPerecivel[] copia = new ProdutoPerecivel[tamanho];
        System.arraycopy(produtos, 0, copia, 0, tamanho);
        return copia;
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