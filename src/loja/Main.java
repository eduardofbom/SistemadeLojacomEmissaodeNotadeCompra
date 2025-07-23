package loja;

import loja.model.produto.*;
import loja.model.cliente.*;
import loja.model.nota.*;
import loja.ui.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Produto> produtos = new ArrayList<>();
    private static List<Cliente> clientes = new ArrayList<>();
    private static List<Nota> notas = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        ConsoleMenu menu = new ConsoleMenu();
        boolean running = true;

        while (running) {
            menu.exibirMenuPrincipal();
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
                    running = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        System.out.println("Sistema encerrado.");
    }

    // Implementação dos métodos de operação (cadastrarProduto, alterarProduto, etc.)
    // ...
}