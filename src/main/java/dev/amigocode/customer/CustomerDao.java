package dev.amigocode.customer;

import dev.amigocode.AmigoApplication;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface CustomerDao {
    List<Customer> selectAllCustomers();
    Optional<Customer> selectCustomerById(Integer id);
    void insertCustomer(Customer customer);
    boolean existsPersonWithEmail(String email);
    boolean existsPersonWithId(Integer id);
    void updateCustomer(Customer update);
    void deleteCustomerById(Integer id);
}
