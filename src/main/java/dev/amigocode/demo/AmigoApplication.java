package dev.amigocode.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
public class AmigoApplication {
    private static List<Customer> customers;
    static {
        customers= new ArrayList<>();
        Customer alex= new Customer(
                1,
                "Alex",
                "alex@gmail.com",
                21
        );

        customers.add(alex);
        Customer jamila= new Customer(
                2,
                "jamila",
                "jamila@gmail.com",
                19
        );

        customers.add(jamila);
    }

    public static void main(String[] args) {
        System.out.println(customers);
        SpringApplication.run(AmigoApplication.class,args);
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    static class Customer {
        private Integer id;
        private String name;
        private String email;
        private Integer age;

    }

}
