package org.ms.clientprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.clientprojetservice.entities.Adresse;
import org.ms.clientprojetservice.entities.Customer;
import org.ms.clientprojetservice.entities.CustomerCategory;
import org.ms.clientprojetservice.entities.ToDoCustomer;
import org.ms.clientprojetservice.repository.AdresseRepository;
import org.ms.clientprojetservice.repository.CustomerCategoryRepository;
import org.ms.clientprojetservice.repository.CustomerRepository;
import org.ms.clientprojetservice.repository.ToDoCustomerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
@Slf4j
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private ToDoCustomerRepository toDoCustomerRepository;
    private AdresseRepository adresseRepository;
    private CustomerCategoryRepository customerCategoryRepository;

    @Override
    public void deleteById(Long id) throws IOException {
//        log.info("client n'existe pas");
        customerRepository.deleteById(id);

    }

    @Override
    public Customer save(Customer customer) {
            adresseRepository.save(customer.getAdresse());
            toDoCustomerRepository.save(customer.getTodocustomer());
        CustomerCategory customerCategory=customerCategoryRepository.getById(customer.getCustomerCategory().getId());
        customer.setCustomerCategory(customerCategory);
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
        Adresse adresse = adresseRepository.getById(customer.getAdresse().getId());
        adresse.setLocalite(customer.getAdresse().getLocalite());
        adresse.setGouvernorat(customer.getAdresse().getGouvernorat());
        adresse.setCodepostale(customer.getAdresse().getCodepostale());
        adresse.setDelegation(customer.getAdresse().getDelegation());

        ToDoCustomer toDoCustomer=toDoCustomerRepository.getById(customer.getTodocustomer().getId());
        toDoCustomer.setActionToDo(customer.getTodocustomer().getActionToDo());
        toDoCustomer.setDateOfAction(customer.getTodocustomer().getDateOfAction());

        CustomerCategory customerCategory=customerCategoryRepository.getById(customer.getCustomerCategory().getId());
        customer.setCustomerCategory(customerCategory);
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> findNewCustomer() {
        Date date1=new Date();
        return customerRepository.findCustomerByAccountOpenedDate(date1);
    }
}
