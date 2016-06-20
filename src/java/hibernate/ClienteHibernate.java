package hibernate;

import java.util.List;
import model.Cliente;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClienteHibernate implements HibernatePersist<Cliente> {

    private Session sessao = null;
    private Transaction transacao = null;
    
    private void abrirConexao(){
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
        } finally {
            
        }
    }
    
    @Override
    public void salvar(Cliente objeto) {
        this.abrirConexao();
        objeto.setAtivo(true);
        sessao.save(objeto);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void atualizar(Cliente objeto) {
        this.abrirConexao();
        sessao.update(objeto);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void deletar(Cliente objeto) {
        this.abrirConexao();
        objeto.setAtivo(false);
        sessao.update(objeto);
        transacao.commit();
        sessao.close();
    }

    @Override
    public List listarTodos(String nome) {
        this.abrirConexao();
        Query query = sessao.createQuery("from Produto where ativo = true and nome like '" + nome+ "%'");
        query.setMaxResults(20);
        List lista = query.list();
        sessao.close();
        return lista;
    }

    @Override
    public List listarAtivo(String nome) {
        this.abrirConexao();
        Query query = sessao.createQuery("from Produto where ativo = true and nome like '" + nome+ "%'");
        query.setMaxResults(20);
        List lista = query.list();
        sessao.close();
        return lista;
    }
    
}
