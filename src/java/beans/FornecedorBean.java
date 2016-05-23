
package beans;

import hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.BeforeCompletion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.PessoaJuridica;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name = "fornecedor")
@RequestScoped
public class FornecedorBean {
    private PessoaJuridica fornecedor = new PessoaJuridica();
    private Session sessao = null;
    public PessoaJuridica getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(PessoaJuridica fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void cadastrar(){
        
        Transaction transacao;
        
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
            System.out.println("Conectou ao banco");
        } finally {
            
        }
        sessao.save(fornecedor);
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
        Criteria lista = sessao.createCriteria(PessoaJuridica.class);
        return lista.list();
        
    }
    
    @BeforeCompletion
    public void fim(){
        sessao.close();
    }
    
}
