
package beans;

import hibernate.FornecedorHibernate;
import hibernate.HibernatePersist;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Fornecedor;
import org.hibernate.Session;

@ManagedBean(name = "fornecedor")
@RequestScoped
public class FornecedorBean {
    private Fornecedor fornecedor = new Fornecedor();
    private Session sessao = null;
    private String nome;
    private HibernatePersist fornecedorHibernate = new FornecedorHibernate();
    
    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    public void cadastrar(){
        fornecedorHibernate.salvar(fornecedor);
        fornecedor = new Fornecedor();
    }
    
    public List getLista(){
        return fornecedorHibernate.listarAtivo(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void atualizarNome(){
        this.nome = fornecedor.getNome();
    }
    
    
    public void excluir(){
       fornecedorHibernate.deletar(fornecedor);
       fornecedor = new Fornecedor();
    }
    
    public void editar(){
        
    }
    
}
