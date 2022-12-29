package org.ms.payementprojetservice.services;

import org.ms.payementprojetservice.entities.Transaction;

import java.util.List;

public interface TransactionService {
    void deleteById(Long id);
    //Map<Transaction,String> save(Transaction transaction);
    Transaction save(Transaction transaction);
    Transaction findById(long id);
    List<Transaction> findAll();
}
