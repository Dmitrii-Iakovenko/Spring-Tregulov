package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
//        Employee employee = new Employee("Zaur", "Tregulov", "It", 500);
//        Employee employee = new Employee("Mikhail", "Ivanov", "HR", 750);
//        Employee employee = new Employee("Alexander", "Smirnov", "Sales", 700);
//        Employee employee = new Employee("Alexander", "Ivanov", "It", 600);
        Employee employee = new Employee("Oleg", "Sidorov", "HR", 700);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
//            Session session = factory.getCurrentSession();
//            session.beginTransaction();
//            session.save(employee);
//            session.getTransaction().commit();
//            session.close();

            long myId = 21;
//            long myId = employee.getId();

            Session sess = factory.openSession();
            Transaction tx = null;
            try {
                tx = sess.beginTransaction();
//                sess.save(employee);
                Employee emp = sess.get(Employee.class, myId);
                tx.commit();
                System.out.println(emp);
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
