package hibernate_one_to_many_uni;

import hibernate_one_to_many_uni.entity.Department;
import hibernate_one_to_many_uni.entity.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Test1 {

    public static void main(String[] args) {
        createAndExecuteSessionFactory();
        System.out.println("DONE");
    }

    private static void executeTransaction(Session session) {
//        Department department = new Department("It", 300, 1200);
//        Department department2 = new Department("HR", 500, 1500);
//        Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//        Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//        Employee emp3 = new Employee("Oleg", "Ivanov", 800);
//        Employee emp4 = new Employee("Andrey", "Sidorov", 1000);
//
//        department.addEmployeeToDepartment(emp1);
//        department.addEmployeeToDepartment(emp2);
//        department2.addEmployeeToDepartment(emp3);
//        department2.addEmployeeToDepartment(emp4);
//        session.save(department);
//        session.save(department2);



//        Department department = session.get(Department.class, 5L);
//        System.out.println(department);
//        department.getEmployees().forEach(System.out::println);




//        Employee employee = session.get(Employee.class, 1L);
//        System.out.println(employee);
//        System.out.println(employee.getDepartment());




//        Employee employee = session.get(Employee.class, 9L);
//        session.delete(employee);
        Department department = session.get(Department.class, 6L);
        session.delete(department);
    }

    private static void createAndExecuteSessionFactory() {
        try (
                SessionFactory factory = new Configuration()
                        .configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Department.class)
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
