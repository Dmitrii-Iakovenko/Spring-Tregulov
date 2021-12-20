package spring;

import org.springframework.context.annotation.*;

@Configuration
//@ComponentScan("spring")
@PropertySource("classpath:myApp.properties")
public class MyConfig {

//    @Bean
//    @Scope("singleton")
    public Pet catBean() {
        return new Cat();
    }

    @Bean
    public Person personBean() {
        return new Person(catBean());
    }



}
