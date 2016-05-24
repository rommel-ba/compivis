
package beans;

import hibernate.HibernateUtil;
import java.io.IOException;
import java.util.List;
import javax.ejb.BeforeCompletion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.Part;
import model.Produto;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name = "produto")
@SessionScoped
public class ProdutoBean {
    private Produto produto = new Produto();
    private Session sessao = null;

    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    public void cadastrar(){
        
        Transaction transacao;
        
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
        } finally {
            
        }
        sessao.save(produto);
        transacao.commit();
        sessao.close();
    }
    
    public List getLista(){
        Transaction transacao;
        
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
            System.out.println("Conectou ao banco");
        } finally {
            
        }
        Criteria lista = sessao.createCriteria(Produto.class);
        return lista.list();
        
    }
    
    @BeforeCompletion
    public void fim(){
        sessao.close();
    }
    
}
