package hibernate_many_to_many;

import hibernate_many_to_many.entity.Child;
import hibernate_many_to_many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Test {

    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;

        try{

//            Section section1 = new Section("Football");
//            Child child1 = new Child("Zaur", 5);
//            Child child2 = new Child("Masha", 7);
//            Child child3 = new Child("Vasya", 6);
//            section1.addChildToSection(child1);
//            section1.addChildToSection(child2);
//            section1.addChildToSection(child3);
//
//            session.beginTransaction();
//
//            session.save(section1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!!!!!");

            //****************************************************************

//            Section section1 = new Section("Volleyball");
//            Section section2 = new Section("Chess");
//            Section section3 = new Section("Math");
//            Child child1 = new Child("Igor", 10);
//            child1.addSectionToChild(section1);
//            child1.addSectionToChild(section2);
//            child1.addSectionToChild(section3);
//
//            session.beginTransaction();
//
//            session.save(child1);
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!!!!!");

//            //****************************************************************
//
//            session = factory.getCurrentSession();
//
//            // prepare date
//            //...
//
//            session.beginTransaction();
//
//            // exchange date
//            Section section = session.get(Section.class, 1L);
//            System.out.println(section);
//            System.out.println(section.getChildren());
//
//            session.getTransaction().commit();
//            System.out.println("Done!!!!!!!");


            //****************************************************************

            session = factory.getCurrentSession();

            // prepare date
            //...

            session.beginTransaction();

            // exchange date
            Child child = session.get(Child.class, 4L);
            System.out.println(child);
            System.out.println(child.getSections());

            session.getTransaction().commit();
            System.out.println("Done!!!!!!!");



        }
        finally {
            factory.close();
        }


    }
}
