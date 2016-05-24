package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/*
* Classe produto, contem os atributos e metodos
* de um produto
*/
@Entity
@Table(name = "produto")
public class Produto implements Serializable{
    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String descricao;
    private float valor;
    private int estoque;
    
    //private final  Lock bankLock = new ReentrantLock();
    //private final  Condition estoqueSuficiente = bankLock.newCondition();
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getEstoque() {
        return estoque;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    /*
    * Metodo para atualizar o estoque do produto
    * @param int estoque - quantidade a ser adicionada ao estoque atual
    */
    public void setEstoque(int estoque) {
        //bankLock.lock(); //Inicio da seção critica
        try{
            this.estoque += estoque;
            //estoqueSuficiente.signalAll();
        }finally{
            //bankLock.unlock(); //Fim da seção critica
        }
    }
    
    /*
    * Metodo para dar baixa no estoque do produto
    * @param int quantidade - quantidade a ser baixada do estoque
    */
    
    public void baixarEstoque (int quantidade){
        //bankLock.lock(); //Inicio da seção critica
        try{
            while(this.estoque <= quantidade)  //verifica se a quantidade a baixar
                try{                           //é menor ou igual a quantidade disponivel
                    //estoqueSuficiente.await(); //coloca a operação em espera caso não haja estoque
                }finally /*catch(InterruptedException e)*/{
                    
                }
            this.estoque -= quantidade; // retira do estoque a quantidade desejada
            
        }finally{
            //bankLock.unlock(); //Fim da seção critica
        }
    }
    
}
