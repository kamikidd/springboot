package dev.amigocode;

import com.github.javafaker.Faker;
import dev.amigocode.customer.Customer;
import dev.amigocode.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Random;

@SpringBootApplication

public class AmigoApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AmigoApplication.class,
                args);
//        String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
//        for (String beanDefinitionName : beanDefinitionNames) {
//            System.out.println(beanDefinitionName);
//        }
        }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository){
        return args->{
            var faker=new Faker();
            var name=faker.name();
            Random random=new Random();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Customer customer = new Customer(

                    firstName+" "+lastName,
                    firstName.toLowerCase()+"."+ lastName.toLowerCase()+"@example.com",
                    random.nextInt(16,99)
            );

            customerRepository.save(customer);
        };
    }
}
