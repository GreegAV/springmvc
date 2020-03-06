package guru.springframework.springmvc.services;

import guru.springframework.springmvc.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Map<Integer, Customer> customers;

    public CustomerServiceImpl() {
        loadCustomers();
    }

    @Override
    public List<Customer> listAllCustomers() {
        return new ArrayList<>(customers.values());
    }

    @Override
    public Customer getById(Integer id) {
        return customers.get(id);
    }

    @Override
    public void delete(Integer id) {
        customers.remove(id);
    }

    @Override
    public Customer saveOrUpdate(Customer customer) {
        if (customer != null) {
            if (customer.getId() == null) {
                customer.setId(getNextKey());
            }
            customers.put(customer.getId(), customer);

            return customer;
        } else {
            throw new RuntimeException("Customer Can't be null");
        }
    }

    private Integer getNextKey() {
        return Collections.max(customers.keySet()) + 1;
    }

    private void loadCustomers() {
        customers = new HashMap<>();

        for (int i = 0; i < 5; i++) {
            Customer customer = new Customer();
            customer.setId(i);
            customer.setFirstName("First Name" + i);
            customer.setLastName("Last Name" + i);
            customer.setEmail("E-Mail" + i);
            customer.setPhoneNumber("phoneNumber" + i);
            customer.setAddress1("Addr1" + i);
            customer.setAddress2("Addr2" + i);
            customer.setCity("City" + i);
            customer.setState("State" + i);
            customer.setZipCode("zipCode" + i);

            customers.put(getNextKey(), customer);
        }


    }
}