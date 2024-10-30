package dev.amigocode.customer;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Repository("List")
public class CustomerListDataAccessService implements CustomerDao{

    private static final List<Customer> customers;

    static {
        customers = new ArrayList<>();
        Customer alex = new Customer(

                "Alex",
                "alex@gmail.com",
                21
        );

        customers.add(alex);
        Customer jamila = new Customer(

                "jamila",
                "jamila@gmail.com",
                19
        );

        customers.add(jamila);
    }
    @Override
    public List<Customer> selectAllCustomers() {
        return customers;
    }

    @Override
    public Optional<Customer> selectCustomerById(Integer id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();

    }
}
