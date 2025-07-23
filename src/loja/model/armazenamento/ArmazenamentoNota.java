package src.loja.model.armazenamento;

import src.loja.model.nota.Nota;
import java.time.LocalDate;

public class ArmazenamentoNota extends Armazenamento {
    private Nota[] notas = new Nota[CAPACIDADE_MAXIMA];
    
    public boolean adicionar(Nota nota) {
        if (nota == null || estaCheio()) {
            return false;
        }
        notas[tamanho++] = nota;
        this.tamanhoAux++;
        return true;
    }
    
    public boolean remover(Nota nota) {
        for (int i = 0; i < tamanho; i++) {
            if (notas[i].equals(nota)) {
                System.arraycopy(notas, i+1, notas, i, tamanho-i-1);
                notas[--tamanho] = null;
                return true;
            }
        }
        return false;
    }
    
    public Nota buscarPorNumero(String numeroNota) {
        for (int i = 0; i < tamanho; i++) {
            if (notas[i].getNumero().equalsIgnoreCase(numeroNota)) {
                return notas[i];
            }
        }
        return null;
    }
    
    public Nota buscarPorCliente(String idCliente) {
        for (int i = 0; i < tamanho; i++) {
            if (notas[i].getCliente().getId().equalsIgnoreCase(idCliente)) {
                return notas[i];
            }
        }
        return null;
    }
    
    public void listarTodos() {
        for (int i = 0; i < tamanhoAux; i++) {
            if (notas[i] == null) {
                continue;
            }
            System.out.println(notas[i].getNumero() + " - " + 
                             notas[i].getData() + " - " + 
                             notas[i].getCliente().getNome() + 
                             " (Total: R$ " + notas[i].calcularTotal() + ")");
        }
    }
    
    public Nota[] listarPorPeriodo(LocalDate dataInicio, LocalDate dataFim) {
        int count = 0;
        for (int i = 0; i < tamanho; i++) {
            if (!notas[i].getData().isBefore(dataInicio) && 
                !notas[i].getData().isAfter(dataFim)) {
                count++;
            }
        }
        
        Nota[] resultado = new Nota[count];
        int index = 0;
        for (int i = 0; i < tamanho; i++) {
            if (!notas[i].getData().isBefore(dataInicio) && 
                !notas[i].getData().isAfter(dataFim)) {
                resultado[index++] = notas[i];
            }
        }
        return resultado;
    }
}
