package loja;

// import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
import loja.model.cliente.*;

public class Teste {
    
 
    public void testPessoaFisica() {
        // Teste de criação
        PessoaFisica pf = new PessoaFisica("CLI001", "João Silva", "Rua A, 123", 
                                         "11999999999", "12345678901", "MG1234567");
        
        // Teste de getters
        System.out.println(pf.getId());
        System.out.println(pf.getNome());
        System.out.println(pf.getCpf());
        System.out.println(pf.getRg());
        
        // Teste de equals
        PessoaFisica pf2 = new PessoaFisica("CLI001", "João Silva", "Rua A, 123", 
                                           "11999999999", "12345678901", "MG1234567");
        System.out.println(pf.equals(pf2));
        
        // Teste de toString
        // expected = "CLI001 - João Silva CPF: 12345678901 RG: MG1234567";
        System.out.println(pf.toString());
        
        // Teste de validação de CPF
        PessoaFisica pfInvalida = new PessoaFisica("CLI002", "Maria", "Rua B", 
                                                  "11888888888", "123", "SP987654");
        System.out.println(pfInvalida.getCpf()); // CPF inválido não deve ser setado
    }
    
  
    public void testPessoaJuridica() {
        // Teste de criação
        PessoaJuridica pj = new PessoaJuridica("EMP001", "Empresa XYZ", "Av. Paulista", 
                                              "1133333333", "12345678000199", "123456789");
        
        // Teste de getters
        System.out.println(pj.getId());
        System.out.println(pj.getNome());
        System.out.println(pj.getCnpj());
        System.out.println(pj.getInscricaoEstadual());
        
        // Teste de equals
        PessoaJuridica pj2 = new PessoaJuridica("EMP001", "Empresa XYZ", "Av. Paulista", 
                                               "1133333333", "12345678000199", "123456789");
        System.out.println(pj.equals(pj2));
        
        // Teste de toString
        // expected = "EMP001 - Empresa XYZ - CNPJ: 12345678000199 - IE: 123456789";
        System.out.println(pj.toString());
    }
}