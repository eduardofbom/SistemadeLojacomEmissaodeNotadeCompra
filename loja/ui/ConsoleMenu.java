// ConsoleMenu.java
package loja.ui;

import loja.model.cliente.*;
import loja.model.produto.*;
import loja.model.nota.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConsoleMenu {
    private List<Produto> produtos = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Nota> notas = new ArrayList<>();

    public void exibirMenuPrincipal() {
        while (true) {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Alterar Produto");
            System.out.println("3. Cadastrar Cliente");
            System.out.println("4. Alterar Cliente");
            System.out.println("5. Criar Nota de Compra");
            System.out.println("6. Listar Notas Emitidas");
            System.out.println("7. Listar Produtos");
            System.out.println("8. Listar Clientes");
            System.out.println("0. Sair");

            int opcao = InputUtils.lerInt("Escolha uma opção: ");

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    alterarProduto();
                    break;
                case 3:
                    cadastrarCliente();
                    break;
                case 4:
                    alterarCliente();
                    break;
                case 5:
                    criarNotaCompra();
                    break;
                case 6:
                    listarNotas();
                    break;
                case 7:
                    listarProdutos();
                    break;
                case 8:
                    listarClientes();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }

    // Os demais métodos permanecem exatamente iguais aos da versão anterior
    // (cadastrarProduto, alterarProduto, cadastrarCliente, alterarCliente,
    // criarNotaCompra, listarNotas, listarProdutos, listarClientes)
    // Apenas removendo os @Override se houver
}
