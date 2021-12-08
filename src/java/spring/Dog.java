package spring;

public class Dog implements Pet {

//    private String name;

    public Dog() {
        System.out.println("spring.Dog bean is created");
    }

    @Override
    public void say() {
        System.out.println("Bow-Wow");
    }

    protected void init() {
        System.out.println("Class spring.Dog: init method");
    }

    private void destroy() {
        System.out.println("Class spring.Dog: destroy method");
    }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
}
