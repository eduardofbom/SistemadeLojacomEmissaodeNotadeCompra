// Nota.java
package loja.model.nota;

import loja.model.cliente.Cliente;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Nota {
    private static int proximoId = 1;
    
    private final int id;
    private final LocalDateTime dataEmissao;
    private final Cliente cliente;
    private final List<ItemNota> itens;
    private BigDecimal total;

    public Nota(Cliente cliente) {
        this.id = proximoId++;
        this.dataEmissao = LocalDateTime.now();
        this.cliente = cliente;
        this.itens = new ArrayList<>();
        this.total = BigDecimal.ZERO;
    }

    public void adicionarItem(ItemNota item) {
        itens.add(item);
        total = total.add(item.getSubtotal());
    }

    public int getId() { return id; }
    public LocalDateTime getDataEmissao() { return dataEmissao; }
    public Cliente getCliente() { return cliente; }
    public List<ItemNota> getItens() { return new ArrayList<>(itens); }
    public BigDecimal getTotal() { return total; }

    public String emitirNota() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== NOTA FISCAL ===\n");
        sb.append("Número: ").append(id).append("\n");
        sb.append("Data: ").append(dataEmissao).append("\n");
        sb.append("Cliente: ").append(cliente.getNome()).append("\n");
        sb.append("Itens:\n");
        
        for (ItemNota item : itens) {
            sb.append("  - ").append(item).append("\n");
        }
        
        sb.append("Total: R$ ").append(String.format("%.2f", total)).append("\n");
        sb.append("===================");
        
        return sb.toString();
    }
}
