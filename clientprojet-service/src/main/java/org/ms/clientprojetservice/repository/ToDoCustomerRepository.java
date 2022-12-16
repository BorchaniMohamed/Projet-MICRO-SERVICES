package org.ms.clientprojetservice.repository;

import org.ms.clientprojetservice.entities.ToDoCustomer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Date;
import java.util.List;

@RepositoryRestController
public interface ToDoCustomerRepository extends JpaRepository<ToDoCustomer,Long> {
    List<ToDoCustomer> findToDoCustomersByDateOfAction(Date date);
}
