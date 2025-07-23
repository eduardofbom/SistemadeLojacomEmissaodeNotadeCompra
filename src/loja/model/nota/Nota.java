package src.loja.model.nota;

import src.loja.model.cliente.Cliente;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Nota {
    private String numero;
    private LocalDate data;
    private Cliente cliente;
    private ItemNota[] itens;
    private int quantidadeItens;
    private static int contadorNotas = 1;
    private static final DateTimeFormatter FORMATO_DATA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final int CAPACIDADE_MAXIMA_ITENS = 100;

    public Nota(Cliente cliente) {
        if (cliente == null) {
            throw new IllegalArgumentException("Cliente não pode ser nulo");
        }
        
        this.numero = gerarNumeroNota();
        this.data = LocalDate.now();
        this.cliente = cliente;
        this.itens = new ItemNota[CAPACIDADE_MAXIMA_ITENS];
        this.quantidadeItens = 0;
    }

    private String gerarNumeroNota() {
        return "NF" + String.format("%04d", contadorNotas++);
    }

    public boolean adicionarItem(ItemNota item) {
        if (item == null || quantidadeItens >= CAPACIDADE_MAXIMA_ITENS) {
            return false;
        }
        itens[quantidadeItens++] = item;
        return true;
    }

    public boolean removerItem(ItemNota item) {
        for (int i = 0; i < quantidadeItens; i++) {
            if (itens[i].equals(item)) {
                System.arraycopy(itens, i + 1, itens, i, quantidadeItens - i - 1);
                itens[--quantidadeItens] = null;
                return true;
            }
        }
        return false;
    }

    public BigDecimal calcularSubtotal() {
        BigDecimal subtotal = BigDecimal.ZERO;
        for (int i = 0; i < quantidadeItens; i++) {
            subtotal = subtotal.add(itens[i].calcularTotal());
        }
        return subtotal;
    }

    public BigDecimal calcularTotal() {
        return calcularSubtotal(); // Pode adicionar impostos/descontos aqui
    }

    public String emitirNotaFormatada() {
        StringBuilder sb = new StringBuilder();
        
        // Cabeçalho
        sb.append("========================================\n");
        sb.append("NOTA FISCAL: ").append(numero).append("\n");
        sb.append("DATA: ").append(data.format(FORMATO_DATA)).append("\n");
        sb.append("CLIENTE: ").append(cliente.getNome()).append("\n");
        sb.append("========================================\n\n");
        
        // Itens
        sb.append("ITENS:\n");
        for (int i = 0; i < quantidadeItens; i++) {
            sb.append(itens[i].toString()).append("\n");
        }
        
        // Totais
        sb.append("\n========================================\n");
        sb.append(String.format("SUBTOTAL: R$ %.2f\n", calcularSubtotal()));
        sb.append(String.format("TOTAL: R$ %.2f\n", calcularTotal()));
        sb.append("========================================\n");
        
        return sb.toString();
    }

    // Getters
    public String getNumero() {
        return numero;
    }

    public LocalDate getData() {
        return data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ItemNota[] getItens() {
        ItemNota[] copia = new ItemNota[quantidadeItens];
        System.arraycopy(itens, 0, copia, 0, quantidadeItens);
        return copia;
    }
    
    public boolean estaCheia() {
        return quantidadeItens >= CAPACIDADE_MAXIMA_ITENS;
    }
}