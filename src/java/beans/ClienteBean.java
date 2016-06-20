package beans;

import hibernate.ClienteHibernate;
import hibernate.HibernatePersist;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Cliente;

@ManagedBean(name = "cliente")
@ViewScoped
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
    
    public void atualizarNome(){
        this.nome = cliente.getNome();
    }
}
