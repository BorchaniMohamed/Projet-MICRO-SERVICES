package org.ms.payementprojetservice.services;

import org.ms.payementprojetservice.entities.Transaction;

import java.util.List;
import java.util.Map;

public interface TransactionService {
    boolean deleteById(Long id);

    //Map<Transaction,String> save(Transaction transaction);
    Transaction save(Transaction transaction);

    Transaction findById(long id);

    List<Transaction> findAll();

    Transaction addInvoice(Transaction invoice);

    Double findTransactionsByInvoice_id(Long id);
}
