package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
*/
public class Venda extends Pedido {
    private Item item;

    public Venda(Pessoa pessoa) {
        this.setPessoa(pessoa);
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyy");
        data.format(new Date(System.currentTimeMillis()));
        this.setData(data.toString());
    }

    
    
    public void addItem(Produto produto, int quantidade){
            item = new Item();
            item.setProduto(produto);
            item.setQuantidade(quantidade);
            items.add(item);
            
    }
    
    public void comprar(){
        for (Item item1 : items){
            item1.getProduto().setEstoque(item1.getQuantidade());
        }
    }
}
