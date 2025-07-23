// InputUtils.java
package loja.ui;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputUtils {
    private static final Scanner sc = new Scanner(System.in);

    public static String lerString(String mensagem) {
        System.out.print(mensagem);
        return sc.nextLine();
    }

    public static int lerInt(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número inteiro.");
            }
        }
    }

    public static BigDecimal lerBigDecimal(String mensagem) {
        while (true) {
            try {
                System.out.print(mensagem);
                return new BigDecimal(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Digite um número decimal (ex: 10.99).");
            }
        }
    }

    public static LocalDate lerData(String mensagem) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            try {
                System.out.print(mensagem + " (dd/MM/yyyy): ");
                String input = sc.nextLine();
                return LocalDate.parse(input, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Data inválida. Use o formato dd/MM/yyyy.");
            }
        }
    }
    
    private static final Scanner scanner = new Scanner(System.in);
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    // Método para ler e validar uma data de validade
    public static LocalDate lerDataValidade(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            String input = scanner.nextLine().trim();
            
            try {
                LocalDate data = LocalDate.parse(input, DATE_FORMATTER);
                
                // Valida se a data é futura
                if (data.isBefore(LocalDate.now())) {
                    System.out.println("Erro: A data deve ser futura. Tente novamente.");
                    continue;
                }
                
                return data;
                
            } catch (DateTimeParseException e) {
                System.out.println("Formato inválido! Use DD/MM/AAAA (ex: 25/12/2024).");
            }
        }
    }
}
