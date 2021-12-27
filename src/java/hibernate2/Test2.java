package hibernate2;

import hibernate2.entity.Detail;
import hibernate2.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test2 {
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

                Detail detail = session.get(Detail.class, 1L);
                detail.getEmployee().setDetail(null);
                session.delete(detail);

                tx.commit();
                System.out.println("DONE");
            } catch (Exception e) {
                System.out.println("ERROR: " + e.toString());
                if (tx!=null) tx.rollback();
                throw e;
            }
        }
    }
}
