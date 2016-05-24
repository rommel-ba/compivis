package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* Classe de itens do pedido
* contem os atributos e metodos relativos
* aos itens do pedido
*/
@Entity
@Table(name = "items")
public class Item implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @ManyToOne(targetEntity = Produto.class)
    private Produto produto; //Produto relativo a um item do pedido
    private float valor; // Valor do produto na data do pedido
    private int quantidade; // Quantidade do mesmo produto nesse item
    private float total; // Valor total do pedido (valor do produto * quantidade)

    /*
    * Metodo que guarda o valor do produto 
    * selecionado no momento da aquisição
    * o metodo e privado para ser acessado somente pelos 
    * objetos da classe
    */
    private void setValor(){
        this.valor = this.produto.getValor();
    }
    
    public float getValor(){
        return this.valor;
    }
    
    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        setTotal();
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
        this.setValor();
    }

    public float getTotal() {
        return this.total;
    }
    
    /* Metodo que calcula o valor total do item
      multiplicando o valor individual pela quantidade
      de produtod do item
    */
    private void setTotal() {
        this.total = this.valor * this.quantidade;
    }
    
}
