package dev.amigocode.customer;

import dev.amigocode.exception.ResourceNotFound;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("Jpa") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }
    public Customer getCustomer(Integer Id) {
        return customerDao.selectCustomerById(Id)
                .orElseThrow(()->new ResourceNotFound("customer with id [%s] not found".formatted(Id)));
    }

}
