package hibernate;

import java.util.List;
import model.Produto;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class ProdutoHibernate implements HibernatePersist<Produto> {

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
    public void salvar(Produto objeto) {
        this.abrirConexao();
        objeto.setAtivo(true);
        sessao.save(objeto);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void atualizar(Produto objeto) {
        this.abrirConexao();
        sessao.update(objeto);
        transacao.commit();
        sessao.close();
    }

    @Override
    public void deletar(Produto objeto) {
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
