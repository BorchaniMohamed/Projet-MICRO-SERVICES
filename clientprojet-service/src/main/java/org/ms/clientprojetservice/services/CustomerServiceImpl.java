package org.ms.clientprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.clientprojetservice.entities.Customer;
import org.ms.clientprojetservice.entities.CustomerCategory;
import org.ms.clientprojetservice.repository.CustomerCategoryRepository;
import org.ms.clientprojetservice.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerCategoryRepository customerCategoryRepository;

    @Override
    public void deleteById(Long id) throws IOException {
//        log.info("client n'existe pas");
        customerRepository.deleteById(id);

    }

    @Override
    public Customer save(Customer customer) {
        if(customer.getAccountOpenedDate()==null) {customer.setAccountOpenedDate(new Date());}
        if(customer.getCustomerCategory()==null) customer.setCustomerCategory(null);
        else
        {
            CustomerCategory customerCategory=customerCategoryRepository.getById(customer.getCustomerCategory().getId());
            customer.setCustomerCategory(customerCategory);
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer findById(long id) {
        return customerRepository.findById(id).get();
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findNewCustomer() {
        Date date1=new Date();
        return customerRepository.findCustomerByAccountOpenedDate(date1);
    }
}
