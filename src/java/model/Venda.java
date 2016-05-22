package model;

import java.lang.annotation.Documented;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Classe venda contem os atributos e metodos 
* para realizar uma venda
*/
public class Venda extends Pedido {
    private Item item;

    /* Metodo construtor da classe Venda
    * @param Pessoa pessoa - Pessoa Juridica (fornecedor)
    */
    public Venda(Pessoa pessoa) {
        this.setPessoa(pessoa); // metodo herdado da classe pedido
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy"); //estabelece o formato para a data
        data.format(new Date(System.currentTimeMillis())); //seta a data da operação como a data atual do sistema
        this.setData(data.toString()); //data convertida em String para metodo herdado da classe pedido
    }

    /* Metodo para adição de itens a venda
    * @param Produto produto - produto a ser adicionado a venda
    * @param int quantidade - quantidade do produto adicionado
    */    
    public void addItem(Produto produto, int quantidade){
            item = new Item();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            this.setItems(item);
            
    }
    
    /* Metodo que da entrada de mercadoria no estoque
    
    */
    public void comprar(){
        for (Item item1 : this.getItems()){
            item1.getProduto().setEstoque(item1.getQuantidade());
        }
    }
}
