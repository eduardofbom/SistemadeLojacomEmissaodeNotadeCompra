package src.loja.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        String input = scanner.nextLine().trim();
        while (input.isEmpty()) {
            System.out.println("Valor não pode ser vazio!");
            System.out.print(mensagem);
            input = scanner.nextLine().trim();
        }
        return input;
    }

    public static int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine().trim();
            if (isInteiroValido(input)) {
                return Integer.parseInt(input);
            }
            System.out.println("Valor inválido! Digite um número inteiro.");
        }
    }

    private static boolean isInteiroValido(String input) {
        if (input.isEmpty()) return false;
        for (char c : input.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static double lerDouble(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine().trim();
            if (isDoubleValido(input)) {
                return Double.parseDouble(input);
            }
            System.out.println("Valor inválido! Digite um número decimal.");
        }
    }

    private static boolean isDoubleValido(String input) {
        if (input.isEmpty()) return false;
        boolean pontoDecimal = false;
        for (char c : input.toCharArray()) {
            if (c == '.') {
                if (pontoDecimal) return false; // Mais de um ponto
                pontoDecimal = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine().trim();
            if (isBigDecimalValido(input)) {
                return new BigDecimal(input);
            }
            System.out.println("Valor monetário inválido! Use o formato 99.99");
        }
    }

    private static boolean isBigDecimalValido(String input) {
        if (input.isEmpty()) return false;
        boolean pontoDecimal = false;
        for (char c : input.toCharArray()) {
            if (c == '.') {
                if (pontoDecimal) return false;
                pontoDecimal = true;
            } else if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static LocalDate lerData(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (DD/MM/AAAA): ");
            String input = scanner.nextLine().trim();
            if (isDataValida(input)) {
                return LocalDate.parse(input, DATE_FORMATTER);
            }
            System.out.println("Data inválida! Use o formato DD/MM/AAAA");
        }
    }

    private static boolean isDataValida(String input) {
        if (input.length() != 10) return false;
        if (input.charAt(2) != '/' || input.charAt(5) != '/') return false;
        
        String[] partes = input.split("/");
        if (partes.length != 3) return false;
        
        return isInteiroValido(partes[0]) && isInteiroValido(partes[1]) && isInteiroValido(partes[2]);
    }

    public static boolean lerSimNao(String mensagem) {
        while (true) {
            System.out.print(mensagem + " (S/N): ");
            String resposta = scanner.nextLine().trim().toUpperCase();
            if (resposta.equals("S")) return true;
            if (resposta.equals("N")) return false;
            System.out.println("Opção inválida! Digite S ou N.");
        }
    }
}