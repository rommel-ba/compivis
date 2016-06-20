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
import model.Produto;

@ManagedBean(name= "comprasBean")
@ViewScoped
public class ComprasBean{

  private Cliente clienteSelecionado;
  private Produto produtoSelecionado = new Produto();
  ClienteHibernate clienteHibernate = new ClienteHibernate();
  CompraHibernate compraHibernate = new CompraHibernate();
  private List<Produto> listaCompras = new ArrayList<Produto>();
  private List<SelectItem> clientesSelect;
  private float valorTotal;
  private String nome;



    public void getBuscaProduto(){
        ProdutoHibernate produtoEscolhido = new ProdutoHibernate();
        Produto produtoPesquisado = new Produto();
        
        if(this.produtoSelecionado.getDescricao() != null && this.produtoSelecionado.getDescricao().equals("")){
            produtoPesquisado = (Produto) produtoEscolhido.listarTodos(this.produtoSelecionado.getDescricao());
            
            if (produtoPesquisado !=null){
                this.listaCompras.add(produtoPesquisado);
                calcularTotal();
            }
        }
    }

    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public Produto getProdutoSelecionado() {
        return produtoSelecionado;
    }

    public void setProdutoSelecionado(Produto produtoSelecionado) {
        this.produtoSelecionado = produtoSelecionado;
    }

    public ArrayList<Produto> getListaCompras() {
        return (ArrayList<Produto>) listaCompras;
    }

    public void setListaCompras(ArrayList<Produto> listaCompras) {
        this.listaCompras = listaCompras;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    public List<SelectItem> getClientesSelect() {
        if(this.clientesSelect == null){
            List<Cliente> listaClientes= clienteHibernate.listarAtivo(nome);
            
            if (listaClientes != null && !listaClientes.isEmpty()){
                SelectItem item;
                for (Cliente clienteLista: listaClientes){
                    item = new SelectItem(clienteLista, clienteLista.getNome());
                    this.clientesSelect.add(item);
                }
            }   
        }
        return clientesSelect;
    }
    
    
    private void calcularTotal() {
        
        valorTotal = 0;
        if(!this.listaCompras.isEmpty()){
            for (Produto p: this.listaCompras){
                valorTotal +=  p.getValor();
            }
        }
    }

  

}
