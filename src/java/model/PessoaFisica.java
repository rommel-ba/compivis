package model;

import java.io.Serializable;

public class PessoaFisica extends Pessoa  {
    
    
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
