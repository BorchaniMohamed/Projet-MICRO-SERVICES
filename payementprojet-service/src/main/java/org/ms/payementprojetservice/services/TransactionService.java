package org.ms.payementprojetservice.services;

import org.ms.payementprojetservice.entities.Transaction;

import java.util.List;

public interface TransactionService {
    void deleteById(Long id);
    //Map<Transaction,String> save(Transaction transaction);
    Transaction save(Transaction transaction,Double aDouble);
    Transaction findById(long id);
    List<Transaction> findAll();

    List<Transaction> findTransactionsByTransactionDate();


}
