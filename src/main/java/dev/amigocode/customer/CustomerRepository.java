package dev.amigocode.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Integer> {

    boolean existsCustomerByEmail(String email);

    boolean existsCustomerById(Integer id);
}
