package hibernate;

import hibernate.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
//        Employee employee = new Employee("Zaur", "Tregulov", "It", 500);
//        Employee employee = new Employee("Mikhail", "Ivanov", "HR", 750);
//        Employee employee = new Employee("Alexander", "Smirnov", "Sales", 700);
        Employee employee = new Employee("Alexander", "Ivanov", "It", 600);

        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .buildSessionFactory();

        try {
            Session session = factory.getCurrentSession();
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();

            System.out.println("DONE");
            System.out.println(employee);
        } finally {
            factory.close();
        }

    }
}
