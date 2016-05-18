package model;

import java.io.Serializable;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Produto implements Serializable {
    private String nome;
    private String descricao;
    private float valor;
    private int estoque;
    private final  Lock bankLock = new ReentrantLock();
    private final  Condition estoqueSuficiente = bankLock.newCondition();
    
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

    public void setEstoque(int estoque) {
        bankLock.lock();
        try{
            this.estoque += estoque;
            estoqueSuficiente.signalAll();
        }finally{
            bankLock.unlock();
        }
    }
    
    public void baixarEstoque (int quantidade){
        bankLock.lock();
        try{
            while(this.estoque < quantidade)
                try{
                    estoqueSuficiente.await();
                }catch(InterruptedException e){
                    
                }
            this.estoque -= quantidade;
            
        }finally{
            bankLock.unlock();
        }
    }
    
}
