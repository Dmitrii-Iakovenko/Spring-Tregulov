package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();

//                Employee employee = session.get(Employee.class, 1L);
//                session.delete(employee);

                session.createQuery("delete Employee where name=:name")
                        .setParameter("name", "Alexander")
                        .executeUpdate();

                tx.commit();
                System.out.println("DONE");
            } catch (Exception e) {
                if (tx!=null) tx.rollback();
                throw e;
            } finally {
                session.close();
            }
        } finally {
            factory.close();
        }

    }

}
