package org.ms.payementprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.payementprojetservice.entities.Transaction;
import org.ms.payementprojetservice.repository.PayementRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService{

    private PayementRepository payementRepository;

    @Override
    public void deleteById(Long id) {
        payementRepository.deleteById(id);
    }

    @Override
    public Transaction save(Transaction transaction,Double antagonised) {
        transaction.setMontant_en_devise(antagonised);
        Transaction savedtransaction = payementRepository.save(transaction);
        return savedtransaction;
        }



    @Override
    public Transaction findById(long id) {
        return payementRepository.findById(id).get();
    }

    @Override
    public List<Transaction> findAll() {
        return payementRepository.findAll();}

    @Override
    public List<Transaction> findTransactionsByTransactionDate() {
        Date date = new Date();
        List<Transaction> transactions = payementRepository.findTransactionsByTransactionDate(date);
        log.info(transactions.toString());
        return transactions;
    }


}
