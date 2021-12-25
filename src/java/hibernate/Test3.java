package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test3 {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session sess = factory.openSession();
            Transaction tx = null;
            try {
                tx = sess.beginTransaction();

//                List<Employee> employees = sess.createQuery("from Employee")
                List<Employee> employees = sess.createQuery("from Employee " +
                        "where name = 'Alexander' and salary>650")
                        .getResultList();
                employees.forEach(System.out::println);

                tx.commit();
            } catch (Exception e) {
                if (tx!=null) tx.rollback();
                throw e;
            } finally {
                sess.close();
            }



            System.out.println("DONE");
        } finally {
            factory.close();
        }

    }

}
