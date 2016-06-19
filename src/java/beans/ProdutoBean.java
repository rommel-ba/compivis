
package beans;

import hibernate.HibernatePersist;
import hibernate.ProdutoHibernate;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Produto;
import org.hibernate.Session;

@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoBean {
    private Produto produto = new Produto();
    private Session sessao = null;
    private String nome;
    private HibernatePersist produtoHibernate = new ProdutoHibernate();

    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
    public void cadastrar(){
        produtoHibernate.salvar(produto);
        produto = new Produto();
    }
    
    public List getLista(){
        return produtoHibernate.listarAtivo(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
