package dev.amigocode.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    boolean existsCustomerByEmail(String email);

    boolean existsCustomerById(Long id);
}
