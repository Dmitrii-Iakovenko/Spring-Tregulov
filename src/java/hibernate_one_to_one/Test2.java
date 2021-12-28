package hibernate_one_to_one;

import hibernate_one_to_one.entity.Detail;
import hibernate_one_to_one.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test2 {

    public static void main(String[] args) {
        createAndExecuteSessionFactory();
        System.out.println("DONE");
    }

    private static void executeTransaction(Session session) {
        Detail detail = session.get(Detail.class, 1L);
        detail.getEmployee().setDetail(null);
        session.delete(detail);
    }

    private static void createAndExecuteSessionFactory() {
        try (
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Detail.class)
                        .buildSessionFactory()
        ) {
            createAndExecuteSession(factory);
        } catch (Exception e) {
            System.out.println("ERROR " + e);
        }
    }

    private static void createAndExecuteSession(SessionFactory factory) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            executeTransaction(session);
            transaction.commit();
        } catch (HibernateException hibernateEx) {
            try {
                if (transaction != null) transaction.rollback();
            } catch (RuntimeException runtimeException) {
                System.out.println("ERROR: " + runtimeException);
            }
            hibernateEx.printStackTrace();
        }
    }

}
