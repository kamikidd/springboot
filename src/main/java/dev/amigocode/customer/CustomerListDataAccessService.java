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
    public Optional<Customer> selectCustomerById(Long id) {
        return customers.stream().filter(c -> c.getId().equals(id)).findFirst();

    }

    @Override
    public void insertCustomer(Customer customer) {
        customers.add(customer);
    }

    @Override
    public boolean existsPersonWithEmail(String email) {
        return customers.stream().anyMatch(c -> c.getEmail().equals(email));
    }

    @Override
    public boolean existsPersonWithId(Long id) {
       return customers.stream().anyMatch(c->c.getId().equals(id));
    }
    //若列表中 ID 唯一，两种方法效果一致。
    //删除所有符合条件的 Customer 对象。
    //removeIf 方法直接在 customers 列表上操作，删除所有符合 c.getId().equals(id) 条件的对象。
    //效果：此方法会删除列表中所有 ID 与 id 相等的 Customer 对象，而不仅仅是第一个匹配的对象。
    @Override
    public void deleteCustomerById(Long id) {
        customers.removeIf(c -> c.getId().equals(id));
    }

//    只删除第一个符合条件的 Customer 对象。
//    这里先通过 filter 方法筛选出与 customerId 匹配的第一个 Customer，然后用 findFirst() 找到第一个匹配的对象。
//    如果找到了匹配的对象，ifPresent(customers::remove) 会从 customers 列表中删除该对象。
//    注意：此方法只删除第一个符合条件的对象，即使有多个对象匹配，也只删除第一个。
//    @Override
//    public void deleteCustomerById(Integer customerId) {
//        customers.stream()
//                .filter(c -> c.getId().equals(customerId))
//                .findFirst()
//                .ifPresent(customers::remove);
//    }


    @Override
    public void updateCustomer(Customer update) {
        customers.add(update);
    }
}
