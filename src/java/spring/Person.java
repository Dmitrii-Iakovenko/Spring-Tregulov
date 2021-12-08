package spring;

public class Person {

    private Pet pet;
    private String surname;
    private int age;

    public Person() {
        System.out.println("spring.Person bean is created");
    }

    public Person(Pet pet) {
        System.out.println("spring.Person bean is created");
        this.pet = pet;
    }

    // pet -> setPet
    public void setPet(Pet pet) {
        System.out.println("Class spring.Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class spring.Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        System.out.println("Class spring.Person: set age");
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely spring.Pet!");
        pet.say();
    }
}
