package spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext2.xml");

//        spring.Dog myDog = context.getBean("myPet", spring.Dog.class);
//        myDog.setName("Belka");
//        spring.Dog yourDog = context.getBean("myPet", spring.Dog.class);
//        yourDog.setName("Strelka");

//        System.out.println(myDog.getName());
//        System.out.println(yourDog.getName());


//        System.out.println("Переменные ссылкаются на один и тот же объект? " +
//                (myDog == yourDog));
//        System.out.println(myDog);
//        System.out.println(yourDog);

        context.close();
    }
}
