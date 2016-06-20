package model;

import javax.persistence.Entity;
import javax.persistence.Table;

/*
* Classe pessoa fisica, contém os atributos e metodos
* relativos aos clientes
*/
@Entity
@Table(name = "pessoa_fisica")
public class Cliente extends Pessoa  {
    
    
    private String cpf;
    private String dataNascimento;

    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
        
}
