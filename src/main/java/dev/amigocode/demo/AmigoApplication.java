package dev.amigocode.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        SpringApplication.run(AmigoApplication.class,args);
    }

    @GetMapping("/customers")
    public List<Customer> getCustomers() {
        return customers;
    }
    @GetMapping("/customers/{customerId}")
    public Customer getCustomers(@PathVariable("customerId") Integer customerId) {
         return customers.stream().filter(c -> c.id.equals(customerId)).findFirst().orElseThrow(()->new IllegalArgumentException("customer with id [%s] not found".formatted(customerId)));
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
