package org.ms.payementprojetservice.repository;


import org.ms.payementprojetservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface PayementRepository extends JpaRepository<Transaction,Long> {}
