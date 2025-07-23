package src.loja.ui;

import src.loja.model.armazenamento.*;
import src.loja.model.cliente.*;
import src.loja.model.produto.*;
import src.loja.model.nota.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ConsoleMenu {
    private final ArmazenamentoProdutoFisico armazenamentoPF;
    private final ArmazenamentoProdutoDigital armazenamentoPD;
    private final ArmazenamentoProdutoPerecivel armazenamentoPP;
    private final ArmazenamentoPessoaFisica armazenamentoPessoasFisicas;
    private final ArmazenamentoPessoaJuridica armazenamentoPessoasJuridicas;
    private final ArmazenamentoNota armazenamentoNotas;

    public ConsoleMenu() {
        this.armazenamentoPF = new ArmazenamentoProdutoFisico();
        this.armazenamentoPD = new ArmazenamentoProdutoDigital();
        this.armazenamentoPP = new ArmazenamentoProdutoPerecivel();
        this.armazenamentoPessoasFisicas = new ArmazenamentoPessoaFisica();
        this.armazenamentoPessoasJuridicas = new ArmazenamentoPessoaJuridica();
        this.armazenamentoNotas = new ArmazenamentoNota();
    }

    public void exibirMenuPrincipal() {
        System.out.println("\n=== SISTEMA DE LOJA ===");
        System.out.println("1. Cadastrar Produto");
        System.out.println("2. Cadastrar Cliente");
        System.out.println("3. Criar Nota de Compra");
        System.out.println("4. Listar Produtos");
        System.out.println("5. Listar Clientes");
        System.out.println("6. Listar Notas");
        System.out.println("0. Sair");
    }

    public void exibirMenuTipoProduto() {
        System.out.println("\nSelecione o tipo de produto:");
        System.out.println("1. Produto Físico");
        System.out.println("2. Produto Digital");
        System.out.println("3. Produto Perecível");
        System.out.println("0. Voltar");
    }

    public void exibirMenuTipoCliente() {
        System.out.println("\nSelecione o tipo de cliente:");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        System.out.println("0. Voltar");
    }

    public void processarOpcao(int opcao) {
        switch (opcao) {
            case 1 -> cadastrarProduto();
            case 2 -> cadastrarCliente();
            case 3 -> criarNotaCompra();
            case 4 -> listarProdutos();
            case 5 -> listarClientes();
            case 6 -> listarNotas();
            case 0 -> System.out.println("Saindo do sistema...");
            default -> System.out.println("Opção inválida!");
        }
    }

    private void cadastrarProduto() {
        exibirMenuTipoProduto();
        int tipo = InputUtils.lerInteiro("Escolha: ");
        if (tipo < 1 || tipo > 3) return;
        
        String codigo = InputUtils.lerString("Código: ");
        String nome = InputUtils.lerString("Nome: ");
        BigDecimal preco = InputUtils.lerBigDecimal("Preço: R$ ");
        
        switch (tipo) {
            case 1 -> {
                double peso = InputUtils.lerDouble("Peso (kg): ");
                BigDecimal frete = InputUtils.lerBigDecimal("Frete: R$ ");
                ProdutoFisico pf = new ProdutoFisico(codigo, nome, preco, peso, frete);
                if (armazenamentoPF.adicionar(pf)) {
                    System.out.println("Produto físico cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar produto!");
                }
            }
            case 2 -> {
                double tamanho = InputUtils.lerDouble("Tamanho (MB): ");
                String link = InputUtils.lerString("Link para download: ");
                ProdutoDigital pd = new ProdutoDigital(codigo, nome, preco, tamanho, link);
                if (armazenamentoPD.adicionar(pd)) {
                    System.out.println("Produto digital cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar produto!");
                }
            }
            case 3 -> {
                double peso = InputUtils.lerDouble("Peso (kg): ");
                BigDecimal frete = InputUtils.lerBigDecimal("Frete: R$ ");
                LocalDate validade = InputUtils.lerData("Data de validade");
                ProdutoPerecivel pp = new ProdutoPerecivel(codigo, nome, preco, peso, frete, validade);
                if (armazenamentoPP.adicionar(pp)) {
                    System.out.println("Produto perecível cadastrado com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar produto!");
                }
            }
        }
    }

    private void cadastrarCliente() {
        exibirMenuTipoCliente();
        int tipo = InputUtils.lerInteiro("Escolha: ");
        if (tipo < 1 || tipo > 2) return;
        
        String id = InputUtils.lerString("ID: ");
        String nome = InputUtils.lerString("Nome: ");
        String endereco = InputUtils.lerString("Endereço: ");
        String telefone = InputUtils.lerString("Telefone: ");
        
        switch (tipo) {
            case 1 -> {
                String cpf = InputUtils.lerString("CPF (apenas números): ");
                String rg = InputUtils.lerString("RG: ");
                PessoaFisica pf = new PessoaFisica(id, nome, endereco, telefone, cpf, rg);
                if (armazenamentoPessoasFisicas.adicionar(pf)) {
                    System.out.println("Pessoa física cadastrada com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar cliente!");
                }
            }
            case 2 -> {
                String cnpj = InputUtils.lerString("CNPJ (apenas números): ");
                String ie = InputUtils.lerString("Inscrição Estadual: ");
                PessoaJuridica pj = new PessoaJuridica(id, nome, endereco, telefone, cnpj, ie);
                if (armazenamentoPessoasJuridicas.adicionar(pj)) {
                    System.out.println("Pessoa jurídica cadastrada com sucesso!");
                } else {
                    System.out.println("Erro ao cadastrar cliente!");
                }
            }
        }
    }

    private void criarNotaCompra() {
        System.out.println("\n=== NOVA NOTA DE COMPRA ===");
        
        // Selecionar cliente
        System.out.println("\nClientes cadastrados:");
        armazenamentoPessoasFisicas.listarTodos();
        armazenamentoPessoasJuridicas.listarTodos();
        
        String idCliente = InputUtils.lerString("\nDigite o ID do cliente: ");
        Cliente cliente = armazenamentoPessoasFisicas.buscarId(idCliente);
        if (cliente == null) {
            cliente = armazenamentoPessoasJuridicas.buscarId(idCliente);
        }
        
        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }
        
        Nota nota = new Nota(cliente);
        boolean continuar = true;
        
        while (continuar && !nota.estaCheia()) {
            System.out.println("\nProdutos disponíveis:");
            armazenamentoPF.listarTodos();
            armazenamentoPD.listarTodos();
            armazenamentoPP.listarTodos();
            
            String codigoProduto = InputUtils.lerString("\nCódigo do produto (ou 'F' para finalizar): ");
            if (codigoProduto.equalsIgnoreCase("F")) {
                continuar = false;
                continue;
            }
            
            Produto produto = armazenamentoPF.buscarPorCodigo(codigoProduto);
            if (produto == null) produto = armazenamentoPD.buscarPorCodigo(codigoProduto);
            if (produto == null) produto = armazenamentoPP.buscarPorCodigo(codigoProduto);
            
            if (produto == null) {
                System.out.println("Produto não encontrado!");
                continue;
            }
            
            int quantidade = InputUtils.lerInteiro("Quantidade: ");
            if (quantidade <= 0) {
                System.out.println("Quantidade inválida!");
                continue;
            }
            
            nota.adicionarItem(new ItemNota(produto, quantidade));
        }
        
        if (armazenamentoNotas.adicionar(nota)) {
            System.out.println("\nNota criada com sucesso!");
            System.out.println(nota.emitirNotaFormatada());
        } else {
            System.out.println("\nErro ao criar nota!");
        }
    }

    private void listarProdutos() {
        System.out.println("\n=== PRODUTOS FÍSICOS ===");
        armazenamentoPF.listarTodos();
        
        System.out.println("\n=== PRODUTOS DIGITAIS ===");
        armazenamentoPD.listarTodos();
        
        System.out.println("\n=== PRODUTOS PERECÍVEIS ===");
        armazenamentoPP.listarTodos();
    }

    private void listarClientes() {
        System.out.println("\n=== PESSOAS FÍSICAS ===");
        armazenamentoPessoasFisicas.listarTodos();
        
        System.out.println("\n=== PESSOAS JURÍDICAS ===");
        armazenamentoPessoasJuridicas.listarTodos();
    }

    private void listarNotas() {
        System.out.println("\n=== NOTAS EMITIDAS ===");
        armazenamentoNotas.listarTodos();
        
        if (InputUtils.lerSimNao("\nDeseja ver os detalhes de alguma nota?")) {
            String numero = InputUtils.lerString("Número da nota: ");
            Nota nota = armazenamentoNotas.buscarPorNumero(numero);
            
            if (nota != null) {
                System.out.println(nota.emitirNotaFormatada());
            } else {
                System.out.println("Nota não encontrada!");
            }
        }
    }
}