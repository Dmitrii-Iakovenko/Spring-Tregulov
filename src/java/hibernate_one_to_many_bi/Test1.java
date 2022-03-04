package hibernate_one_to_many_bi;

import hibernate_one_to_many_bi.entity.Department;
import hibernate_one_to_many_bi.entity.Employee;
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
        // ADD
//        Department department = new Department("Sales", 800, 1500);
//        Employee emp1 = new Employee("Zaur", "Tregulov", 800);
//        Employee emp2 = new Employee("Elena", "Smirnova", 1500);
//        Employee emp3 = new Employee("Anton", "Sidorov", 1200);
//        department.addEmployeeToDepartment(emp1);
//        department.addEmployeeToDepartment(emp2);
//        department.addEmployeeToDepartment(emp3);
//        session.save(department);



        // GET
        System.out.println("Get department");
        Department department = session.get(Department.class, 7L);

        System.out.println("Show department");
        System.out.println(department);

        System.out.println("Show employees of the department");
        department.getEmployees().forEach(System.out::println);




//        Employee employee = session.get(Employee.class, 1L);
//        System.out.println(employee);
//        System.out.println(employee.getDepartment());

        // DELETE
//        Employee employee = session.get(Employee.class, 4L);
//        session.delete(employee);
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
