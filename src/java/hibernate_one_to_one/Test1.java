package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test1 {
    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory()
        ){
            Transaction tx = null;
            try (Session session = factory.openSession())
            {
                tx = session.beginTransaction();

                Employee employee = session.get(Employee.class, 2L);
                session.delete(employee);

                tx.commit();
                System.out.println("DONE");
            } catch (Exception e) {
                if (tx!=null) tx.rollback();
                throw e;
            }
        }
    }
}
