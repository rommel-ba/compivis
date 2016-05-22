package model;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
* Classe pessoa juridica
* Contem os atributos e metodos de uma pessoa Juridica
*/

@Entity
@Table(name = "pessoa_juridica")
public class PessoaJuridica extends Pessoa{
    
    private String cnpj;
    private String telefone;

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

}
