package model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/* Classe venda contem os atributos e metodos 
* para realizar uma venda
*/
@Entity
@Table(name = "vendas")
public class Venda extends Pedido {
    @ManyToOne(targetEntity = Fornecedor.class)
    private Fornecedor pessoaJuridica;
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    private List<Item> items;

    public Venda() {
        this.items = new ArrayList<>();
    }

    /* Metodo construtor da classe Venda
    * @param Pessoa pessoa - Pessoa Juridica (fornecedor)
    */
    public Venda(Fornecedor pessoaJuridica) {
        this.items = new ArrayList<>();
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy"); //estabelece o formato para a data
        data.format(new Date(System.currentTimeMillis())); //seta a data da operação como a data atual do sistema
        this.setData(data.toString()); //data convertida em String para metodo herdado da classe pedido
    }

    /* Metodo para adição de itens a venda
    * @param Produto produto - produto a ser adicionado a venda
    * @param int quantidade - quantidade do produto adicionado
    */    
    public void addItem(Produto produto, int quantidade){
            Item item = new Item();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            items.add(item);
            
    }
    
    /* Metodo que da entrada de mercadoria no estoque
    
    */
    public void comprar(){
        for (Item item1 : items){
            item1.getProduto().setEstoque(item1.getQuantidade());
        }
    }
}
