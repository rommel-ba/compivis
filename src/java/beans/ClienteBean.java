package beans;

import hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.BeforeCompletion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.PessoaFisica;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name = "cliente")
@RequestScoped
public class ClienteBean {
    private PessoaFisica cliente = new PessoaFisica();
    private Session sessao = null;
    
    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }
    
    public void cadastrar(){
        
        Transaction transacao;
        
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
        } finally {
            
        }
        sessao.save(cliente);
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
        Criteria lista = sessao.createCriteria(PessoaFisica.class);
        return lista.list();
        
    }
    
    @BeforeCompletion
    public void fim(){
        sessao.close();
    }
    
}
