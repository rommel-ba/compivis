package teste;

import hibernate.HibernatePersist;
import hibernate.HibernateUtil;
import hibernate.ProdutoHibernate;
import model.Compra;
import model.Item;
import model.Cliente;
import model.Produto;
import org.hibernate.Query;
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
        String consulta = "9";
        Query query = sessao.createQuery("from Cliente");
        query.setMaxResults(1);
        Cliente pessoa = (Cliente) query.uniqueResult();
        System.out.println("Query primeira pessoa = "+pessoa.getNome());
        
        
        
        query = sessao.createQuery("from Produto");
        query.setMaxResults(1);
        Produto produto = (Produto) query.uniqueResult();
        //System.out.println("Deletar produto = " + produto.getNome());
        
        HibernatePersist persist = new ProdutoHibernate();
        //produto.setNome("Produto 2");
        //persist.deletar(produto);
        System.out.println("Listar produtos");
        for(Object p : persist.listarAtivo("p")){
            produto = (Produto) p;
            System.out.println(produto.getNome());
        }
        /*
        Compra compra = new Compra();
        compra.setPessoaFisica(pessoa);
        compra.addItem(produto, 5);
        sessao.save(compra);
        transacao.commit();
        
        query = sessao.createQuery("from Compra");
        query.setMaxResults(1);
        compra = (Compra) query.uniqueResult();
        System.out.println("Pessoa da compra = " + compra.getPessoaFisica().getNome()+"\n"
                + "Produto da compra = " + compra.getProduto().getProduto().getNome() +"\n"
                + "Valor = " + compra.getProduto().getProduto().getValor()+ "\n"
                + "Quantidade = " + compra.getProduto().getQuantidade()+ "\n"
                + "Total = " + compra.getProduto().getTotal());
        //sessao.save(pedido);
        //transacao.commit();
        
        sessao.close();
                
        */
    }
}
