
package beans;

import hibernate.HibernateUtil;
import javax.faces.bean.ManagedBean;
import model.PessoaFisica;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name = "cliente")
public class ClienteBean {
    private PessoaFisica cliente = new PessoaFisica();

    public PessoaFisica getCliente() {
        return cliente;
    }

    public void setCliente(PessoaFisica cliente) {
        this.cliente = cliente;
    }
    
    public void cadastrar(){
        Session sessao = null;
        Transaction transacao;
        
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
            System.out.println("Conectou ao banco");
        } finally {
            
        }
        sessao.save(cliente);
        transacao.commit();
        sessao.close();
    }
    
}
