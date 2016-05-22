package teste;

import hibernate.HibernateUtil;
import model.PessoaFisica;
import model.PessoaJuridica;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class TesteBanco {
    public static void main(String args[]){
       
        Session sessao = null;
        Transaction transacao;
        
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
            System.out.println("Conectou ao banco");
        } finally {
            
        }
        
        PessoaJuridica juridica = new PessoaJuridica();
        juridica.setNome("Juridica");
        sessao.save(juridica);
        transacao.commit();
        sessao.close();
        
        try {
            sessao = HibernateUtil.getSession().openSession();
            transacao = sessao.beginTransaction();
            System.out.println("Conectou ao banco");
        } finally {
            
        }
        
        PessoaFisica fisica = new PessoaFisica();
        fisica.setNome("Fisica real");
        sessao.save(fisica);
        transacao.commit();
    }
}
