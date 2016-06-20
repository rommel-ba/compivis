package hibernate;

import java.util.List;
import model.Venda;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class VendasHibernate implements HibernatePersist<Venda> {


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
    public void salvar(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void atualizar(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deletar(Venda objeto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarTodos(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listarAtivo(String nome) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}