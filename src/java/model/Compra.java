package model;

import java.text.SimpleDateFormat;
import java.util.Date;
/*Classe Compra
* Extende a classe pedido
* Definindo os atributos e métodos 
* para um cliente realizar uma compra
*/

public class Compra extends Pedido {
    
    private Item item;

  /*Metodo construtor da classe Compra
    @param Pessoa pessoa - pessoa que realiza o pedido
    
    */  
    public Compra(Pessoa pessoa) {
        this.setPessoa(pessoa);
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyy");
        data.format(new Date(System.currentTimeMillis()));
        this.setData(data.toString());
    }
    
    /* Metodo para adicionar itens a compra
    * @param Produto produto - produto a ser adicionado a compra
    * @param int quantidade - quantidade do produto a ser adicionado    
    */
    public void addItem(Produto produto, int quantidade){
            item = new Item();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            this.setItems(item);
            
    }
    
    /* Metodo para efetuar a compra dos itens adicionados
    */
    public void comprar(){
        for (Item item1 : this.getItems()){
            item1.getProduto().baixarEstoque(item1.getQuantidade());
        }
        
    }
}
