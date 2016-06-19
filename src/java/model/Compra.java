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
/*Classe Compra
* Extende a classe pedido
* Definindo os atributos e métodos 
* para um cliente realizar uma compra
*/
@Entity
@Table(name = "compras")
public class Compra extends Pedido {
    @ManyToOne(targetEntity = PessoaFisica.class, cascade = CascadeType.ALL)
    private PessoaFisica pessoaFisica;
    
    @OneToMany(targetEntity = Item.class, cascade = CascadeType.ALL)
    private List<Item> items = new ArrayList<>();

    public Compra() {
    }

  /*Metodo construtor da classe Compra
    @param Pessoa pessoa - pessoa que realiza o pedido
    
    */  
    public Compra(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyy");
        data.format(new Date(System.currentTimeMillis()));
        this.setData(data.toString());
    }

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }
    
    
    
    /* Metodo para adicionar itens a compra
    * @param Produto produto - produto a ser adicionado a compra
    * @param int quantidade - quantidade do produto a ser adicionado    
    */
    public void addItem(Produto produto, int quantidade){
            Item item = new Item();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            items.add(item);
            
    }
    
    /* Metodo para efetuar a compra dos itens adicionados
    */
    public void comprar(){
        for (Item item1 : items){
            item1.getProduto().baixarEstoque(item1.getQuantidade());
        }
        
    }
    
    public Item getProduto(){
        return items.get(0);
    }
}
