package dev.amigocode;

import dev.amigocode.customer.Customer;
import dev.amigocode.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.List;

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
            Customer alex = new Customer(

                    "Alex",
                    "alex@gmail.com",
                    21
            );

            Customer jamila = new Customer(

                    "jamila",
                    "jamila@gmail.com",
                    19
            );
            List<Customer> customers = List.of(alex,
                    jamila);
//            customerRepository.saveAll(customers);
        };
    }
}
