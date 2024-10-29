package dev.amigocode.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }
    public Customer getCustomer(Integer Id) {
        return customerDao.selectCustomerById(Id)
                .orElseThrow(()->new IllegalArgumentException("customer with id [%s] not found".formatted(Id)));
    }

}
