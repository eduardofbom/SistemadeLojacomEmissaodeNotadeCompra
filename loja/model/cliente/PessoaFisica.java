// PessoaFisica.java
package loja.model.cliente;

public class PessoaFisica extends Cliente {
    private String cpf;
    private String rg;

    public PessoaFisica(String identificador, String nome, String endereco, String telefone, String cpf, String rg) {
        super(identificador, nome, endereco, telefone);
        this.rg = rg;
        if (checkCpf(cpf) {
            this.cpf = cpf;
        } else {
            System.out.println("CPF INVALIDO NAO CADASTRADO!");
        }
    }

    // Getters específicos
    public String getCpf() {
        return this.cpf;
    }
    public String getRg() {
        return this.rg;
    }
    

    // metodo para verificar cpf
    private boolean checkCpf(cpf) {
        if(cpf.lenght() != 11) {
            System.out.println("CPF cadastrado está incorreto!%nPrecisa ter 9 dígitos!");
            return false;
        }else{
            return true;
        }
    }

    // equal()
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PessoaFisica that = (PessoaFisica) o;
        return cpf.equals(that.cpf);
    }

    // toString()
    public String toString() {
        return super.toString() +
            String.format(" - CPF: %s - RG: %s",this.cpf,this.rg);
    }
}
