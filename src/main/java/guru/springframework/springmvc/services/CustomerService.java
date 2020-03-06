package guru.springframework.springmvc.services;

import guru.springframework.springmvc.domain.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> listAll();

    Customer getById(Integer id);

    Customer saveOrUpdate(Customer customer);

    void delete(Integer id);
}
