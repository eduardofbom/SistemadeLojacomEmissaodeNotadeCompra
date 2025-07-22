package loja;

public class ConsoleMenu {
    public void exibirMenuPrincipal() {
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
    }

    public void exibirMenuTipoProduto() {
        System.out.println("\nSelecione o tipo de produto:");
        System.out.println("1. Produto Físico");
        System.out.println("2. Produto Digital");
        System.out.println("3. Produto Perecível");
    }

    public void exibirMenuTipoCliente() {
        System.out.println("\nSelecione o tipo de cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
    }
}