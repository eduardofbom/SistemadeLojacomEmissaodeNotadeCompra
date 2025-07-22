// PessoaFisica.java
package loja.model.cliente;

public class PessoaFisica extends Cliente {
	protected String cpf;
    protected String rg;

    public PessoaFisica(String idUnico, String nome, String endereco, String telefone, String cpf, String rg) {
        super(idUnico, nome, endereco, telefone);
        this.rg = rg;
        if (checkCpf(cpf)) {
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
    private boolean checkCpf(String cpf) {
        if(cpf.length() != 11) {
            System.out.println("CPF cadastrado está incorreto!%nPrecisa ter 9 dígitos!");
            return false;
        }else{
            return true;
        }
    }

    // equal()
    public boolean equals(Object o) {
        if (this == o) {
        	return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
        	return false;
        }
        if (!super.equals(o)) {
        	return false;
        }
        PessoaFisica temp = (PessoaFisica) o;
        return cpf.equals(temp.cpf);
    }

    // toString()
    public String toString() {
        return super.toString() +
            String.format(" - CPF: %s - RG: %s",this.cpf,this.rg);
    }
}
