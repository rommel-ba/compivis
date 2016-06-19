package beans;

import hibernate.ClienteHibernate;
import hibernate.HibernatePersist;
import hibernate.HibernateUtil;
import java.util.List;
import javax.ejb.BeforeCompletion;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Cliente;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

@ManagedBean(name = "cliente")
@RequestScoped
public class ClienteBean {
    private Cliente cliente = new Cliente();
    private String nome;
    private HibernatePersist clienteHibernate = new ClienteHibernate();
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public void cadastrar(){
        clienteHibernate.salvar(cliente);
        cliente = new Cliente();
    }
    
    public List getLista(){
        return clienteHibernate.listarAtivo(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
