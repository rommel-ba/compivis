
package hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessao = buildSessionFactory();
    
    private static SessionFactory buildSessionFactory() {
        try {
            Configuration config = new Configuration().configure("hibernate.cfg.xml");
            return config.buildSessionFactory();
        } catch (Exception e) {
            System.out.println("Deu ruim " + e);
        }
        return null;
    }
    
    public static SessionFactory getSession(){
        return sessao;
    }
    
}
