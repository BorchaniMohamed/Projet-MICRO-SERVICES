package org.ms.clientprojetservice.services;

import org.ms.clientprojetservice.entities.Customer;

import java.io.IOException;
import java.util.List;

public interface CustomerService {

    void deleteById(Long id) throws IOException;
    Customer save(Customer customer);
    Customer findById(long id);
    List<Customer> findAll();

    Customer update(Customer customer);
    List<Customer> findNewCustomer();
}
