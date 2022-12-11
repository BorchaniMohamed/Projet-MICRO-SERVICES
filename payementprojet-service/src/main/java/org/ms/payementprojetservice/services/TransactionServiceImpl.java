package org.ms.payementprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.payementprojetservice.entities.Invoce.Invoice;
import org.ms.payementprojetservice.entities.Transaction;
import org.ms.payementprojetservice.feign.ClientServiceClient;
import org.ms.payementprojetservice.feign.FactureServiceClient;
import org.ms.payementprojetservice.repository.PayementRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class TransactionServiceImpl implements TransactionService{

    private PayementRepository payementRepository;
    private ClientServiceClient clientServiceClient;
    private FactureServiceClient factureServiceClient;

    @Override
    public boolean deleteById(Long id) {
        if(payementRepository.existsById(id)){payementRepository.deleteById(id); return true;}
        return false;
    }

    @Override
    //public Map<Transaction,String> save(Transaction transaction) {
    public Transaction save(Transaction transaction) {
        //Map<Transaction, String> coordinates = new HashMap<>();
        transaction = payementRepository.save(transaction);
        transaction = this.addInvoice(transaction);
        if (transaction.getInvoice()==null)
        {
            this.deleteById(transaction.getId());
            //coordinates.put(null, "Facture inexistante");
            //return coordinates;
            return null;
        }
        else if("payed"==transaction.getInvoice().getStates())
        {
            //log.info("Facture Déja Payé");
            this.deleteById(transaction.getId());
            //coordinates.put(null, "Facture Déja Payé");
            //return coordinates;
            return null;
        }
        else if(transaction.getAmounttransaction()>transaction.getInvoice().getAmount()) {

            //log.info("\"Montant à payer superieure au montant de la facture\"");
            this.deleteById(transaction.getId());
            //coordinates.put(null, "Montant à payer superieure au montant de la facture");
            //return coordinates;
            return null;
        }
        else{
            transaction = payementRepository.save(transaction);
            //coordinates.put(transaction, "transaction avec sucée");
            //return coordinates;
            return transaction;
        }

    }

    @Override
    public Transaction findById(long id) {
        return payementRepository.findById(id)
                .map(this::addInvoice)
                .orElse(null);
    }

    @Override
    public List<Transaction> findAll() {
        return payementRepository.findAll()
                .stream()
                .map(this::addInvoice)
                .collect(Collectors.toList());
    }

    @Override
    public Transaction addInvoice(Transaction t) {
//        Customer client = clientServiceClient.findClientById(t.getCostumer_id());
//        t.setCustomer(client);
        Invoice invoice = factureServiceClient.findInvoiceById(t.getInvoice_id());
        if(invoice!=null) {
            t.setInvoice(invoice);
            return t;
        }
        else return t;
    }

    @Override
    public Double findTransactionsByInvoice_id(Long id) {
        return payementRepository.findTransactionsByInvoice_id(id);
    }
}
