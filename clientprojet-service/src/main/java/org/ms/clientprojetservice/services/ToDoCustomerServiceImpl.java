package org.ms.clientprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.clientprojetservice.entities.Customer;
import org.ms.clientprojetservice.entities.ToDoCustomer;
import org.ms.clientprojetservice.repository.CustomerRepository;
import org.ms.clientprojetservice.repository.ToDoCustomerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
@AllArgsConstructor
public class ToDoCustomerServiceImpl implements ToDoCustomerService{
    private ToDoCustomerRepository toDoCustomerRepository;
    private CustomerRepository customerRepository;
    @Override
    public void deleteById(Long id) throws IOException {
          toDoCustomerRepository.deleteById(id);
    }

    @Override
    public ToDoCustomer save(ToDoCustomer toDoCustomer) {
        return toDoCustomerRepository.save(toDoCustomer);
    }

    @Override
    public ToDoCustomer findById(long id) {
        return toDoCustomerRepository.findById(id).get();
    }

    @Override
    public List<ToDoCustomer> findAll() {
        return toDoCustomerRepository.findAll();
    }

    @Override
    public List<ToDoCustomer> findNewToDoCustomers() {
        Date date1=new Date();
        List<Customer> customers = customerRepository.findCustomerByAccountOpenedDate(date1);
        List<ToDoCustomer> toDoCustomers = new ArrayList<>();
        for(Customer c : customers){
            toDoCustomers.add(c.getTodocustomer());
        }
        return toDoCustomers;
    }
}
