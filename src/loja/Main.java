package src.loja;

// import src.loja.ui.ConsoleMenu;
// import src.loja.ui.InputUtils;
import src.loja.ui.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE LOJA ===");
        System.out.println("Inicializando armazenamentos...");
        
        // Inicializa o menu do sistema
        ConsoleMenu menu = new ConsoleMenu();
        int opcao;
        
        // Loop principal do sistema
        do {
            menu.exibirMenuPrincipal();
            opcao = InputUtils.lerInteiro("Escolha uma opção: ");
            menu.processarOpcao(opcao);
            
            // Pausa para visualização
            if (opcao != 0) {
                System.out.println("\nPressione Enter para continuar...");
                InputUtils.lerString("");
            }
        } while (opcao != 0);
        
        System.out.println("Sistema encerrado.");
    }
}