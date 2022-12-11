package org.ms.clientprojetservice.repository;

import org.ms.clientprojetservice.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Date;
import java.util.List;

@RepositoryRestController
public interface CustomerRepository extends JpaRepository<Customer,Long> {

    List<Customer> findCustomerByAccountOpenedDate(Date acDate);
}
