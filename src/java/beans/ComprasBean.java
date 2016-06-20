package beans;

import hibernate.ClienteHibernate;
import hibernate.CompraHibernate;
import hibernate.ProdutoHibernate;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.model.SelectItem;
import model.Cliente;
import model.Compra;
import model.Item;
import model.Produto;

@ManagedBean(name = "comprasBean")
@ViewScoped
public class ComprasBean {

    private Cliente clienteSelecionado;
    private Compra compra = new Compra();
    private Produto produto;
    private CompraHibernate compraHibernate = new CompraHibernate();
    private ArrayList<Item> itens = new ArrayList<>();

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public void addItem() {
        Item item = new Item();
        item.setProduto(produto);
        itens.add(item);
    }
    public List getListaItens(){
        return itens;
    }
    
    public int getTamanho() {
        return itens.size();
    }
}
