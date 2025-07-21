// PessoaFisica.java
package loja.model.cliente;

public class PessoaFisica extends Cliente {
    private String cpf;

    public PessoaFisica(String identificador, String nome, String endereco, String telefone, String cpf) {
        super(identificador, nome, endereco, telefone);
        this.cpf = cpf;
    }

    // Getter específico
    public String getCpf() { return cpf; }

    @Override
    public String toString() {
        return super.toString() + " - CPF: " + cpf;
    }
}
