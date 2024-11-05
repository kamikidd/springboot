package dev.amigocode.customer;

import dev.amigocode.exception.DuplicateResourceException;
import dev.amigocode.exception.RequestValidationException;
import dev.amigocode.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerDao customerDao;

    public CustomerService(@Qualifier("jdbc") CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    public List<Customer> getAllCustomers() {
        return customerDao.selectAllCustomers();
    }

    public Customer getCustomer(Long Id) {
        return customerDao.selectCustomerById(Id)
                .orElseThrow(() -> new ResourceNotFoundException("customer with id [%s] not found".formatted(Id)));
    }

    public void addCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        //check if email exists
        String email = customerRegistrationRequest.email();
        if (customerDao.existsPersonWithEmail(email)) {
            throw new DuplicateResourceException("Email already taken");
        }
        //add
        Customer customer = new Customer(
                customerRegistrationRequest.name(),
                customerRegistrationRequest.email(),
                customerRegistrationRequest.age()
        );
        customerDao.insertCustomer(customer);

    }

    public void deleteCustomer(Long Id) {
        //check if id exists
        if (!customerDao.existsPersonWithId(Id)) {
            throw new ResourceNotFoundException("customer with id [%s] not found".formatted(Id));
        }
        //delete
        customerDao.deleteCustomerById(Id);

    }

    public void updateCustomer(Long Id, CustomerUpdateRequest customerUpdateRequest) {
        //First get customer old data
        Customer customer = getCustomer(Id);

        boolean isChanged = false;

        if (customerUpdateRequest.name() != null && !customerUpdateRequest.name()
                .equals(customer.getName())) {

            customer.setName(customerUpdateRequest.name());
            isChanged = true;
        }

        if (customerUpdateRequest.age() != null && !customerUpdateRequest.age()
                .equals(customer.getAge())) {

            customer.setAge(customerUpdateRequest.age());
            isChanged = true;
        }

        if (customerUpdateRequest.email() != null && !customerUpdateRequest.email()
                .equals(customer.getEmail())) {
            if (customerDao.existsPersonWithEmail(customerUpdateRequest.email())) {
                throw new DuplicateResourceException("Email already taken");
            }
            isChanged = true;
            customer.setEmail(customerUpdateRequest.email());
        }
        if (!isChanged) {
            throw new RequestValidationException("no data changes found");
        }
        customerDao.updateCustomer(customer);

    }


}
