// PessoaJuridica.java
package loja.model.cliente;

public class PessoaJuridica extends Cliente {
	protected String cnpj;
	protected String inscricaoEstadual;

    public PessoaJuridica(String idUnico, String nome, String endereco, String telefone, 
                          String cnpj, String inscricaoEstadual) {
        super(idUnico, nome, endereco, telefone);
        this.cnpj = cnpj;
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getCnpj() {
    	return cnpj;
    }
    public String getInscricaoEstadual() {
    	return inscricaoEstadual;
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
        PessoaJuridica temp = (PessoaJuridica) o;
        return cnpj.equals(temp.cnpj);
    }

    public String toString() {
        return super.toString() + 
        		String.format(" - CNPJ: %s - IE: %s",this.cnpj,this.inscricaoEstadual);
    }
}
