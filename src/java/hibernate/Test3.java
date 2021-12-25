package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.Query;
import java.util.List;

public class Test3 {
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

                String query = "from Employee where name=:name and salary>:salary";
                List<Employee> employees = session.createQuery(query, Employee.class)
                        .setParameter("name", "Alexander")
                        .setParameter("salary", 650)
                        .list();
                employees.forEach(System.out::println);

                tx.commit();
            } catch (Exception e) {
                if (tx!=null) tx.rollback();
                throw e;
            } finally {
                session.close();
            }



            System.out.println("DONE");
        } finally {
            factory.close();
        }

    }

}
