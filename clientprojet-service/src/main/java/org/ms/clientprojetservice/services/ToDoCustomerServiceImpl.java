package org.ms.clientprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.clientprojetservice.entities.ToDoCustomer;
import org.ms.clientprojetservice.repository.ToDoCustomerRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class ToDoCustomerServiceImpl implements ToDoCustomerService{
    private ToDoCustomerRepository toDoCustomerRepository;
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
}
