package org.ms.clientprojetservice.services;

import org.ms.clientprojetservice.entities.ToDoCustomer;

import java.io.IOException;
import java.util.List;

public interface ToDoCustomerService {
    void deleteById(Long id) throws IOException;
    ToDoCustomer save(ToDoCustomer toDoCustomer);
    ToDoCustomer findById(long id);
    List<ToDoCustomer> findAll();
}
