import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test3 {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

//        Pet pet = new Cat();
        Person person = new Person(context.getBean("myPet", Pet.class));
        person.callYourPet();

        context.close();
    }
}
