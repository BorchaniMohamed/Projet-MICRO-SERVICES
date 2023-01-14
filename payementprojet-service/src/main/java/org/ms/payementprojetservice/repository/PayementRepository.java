package org.ms.payementprojetservice.repository;


import org.ms.payementprojetservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Date;
import java.util.List;

@RepositoryRestController
public interface PayementRepository extends JpaRepository<Transaction, Long> {
    @Query("select t from Transaction t where year(t.transactionDate) = year(?1) " +
            "and month(t.transactionDate) = month(?1) " +
            "and day(t.transactionDate) = day(?1)")
    List<Transaction> findTransactionsByTransactionDate(Date date);
}


