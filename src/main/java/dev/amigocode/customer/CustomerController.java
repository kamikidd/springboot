package dev.amigocode.customer;

import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getCustomers() {
        return customerService.getAllCustomers();
    }
    @GetMapping("{customerId}")
    public Customer getCustomers(@PathVariable("customerId") Long customerId) {
        return customerService.getCustomer(customerId);
    }
    @PostMapping
    public void registerCustomer(@RequestBody CustomerRegistrationRequest request) {
        customerService.addCustomer(request);
    }
    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Long customerId) {
        customerService.deleteCustomer(customerId);
    }
    @PutMapping("{customerId}")
    public void updateCustomer(@RequestBody CustomerUpdateRequest request, @PathVariable("customerId") Long customerId) {
        customerService.updateCustomer(customerId,request);
    }

}
