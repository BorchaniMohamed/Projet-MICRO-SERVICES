package org.ms.payementprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.payementprojetservice.entities.Transaction;
import org.ms.payementprojetservice.repository.PayementRepository;
import org.springframework.stereotype.Service;

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
    public Transaction save(Transaction transaction) {
        return payementRepository.save(transaction);
        }



    @Override
    public Transaction findById(long id) {
        return payementRepository.findById(id).get();
    }

    @Override
    public List<Transaction> findAll() {
        return payementRepository.findAll();}




}
