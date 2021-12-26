package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test4 {
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
//                employee.setSalary(1500);

                session.createQuery("update Employee set salary=:salary where name=:name")
                        .setParameter("salary", 1000)
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
