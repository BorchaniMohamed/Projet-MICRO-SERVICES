package org.ms.payementprojetservice.web;

import lombok.AllArgsConstructor;
import org.ms.payementprojetservice.entities.Transaction;
import org.ms.payementprojetservice.feign.ClientServiceClient;
import org.ms.payementprojetservice.feign.FactureServiceClient;
import org.ms.payementprojetservice.repository.PayementRepository;
import org.ms.payementprojetservice.services.TransactionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class TransactionController {

    private TransactionService transactionService;
    private ClientServiceClient clientServiceClient;
    private FactureServiceClient factureServiceClient;


    @GetMapping("/transactions")
    private List<Transaction> findAll(){
        List<Transaction> all = transactionService.findAll();
        return all;
    }
    @GetMapping("/transactions/{id}")
    private Transaction findTransactionById(@PathVariable Long id){
        Transaction transaction = transactionService.findById(id);
        return transaction;

    }
    @GetMapping("transactions/facture/{id}")
    private Double findTransactionByInvoiceId(@PathVariable Long id){
        return transactionService.findTransactionsByInvoice_id(id);
    }
    @PostMapping("/transactions")
    public ResponseEntity save(@RequestBody Transaction transaction){
        //Map<Transaction, String> coordinates = transactionService.save(transaction);
        Transaction  coordinates = transactionService.save(transaction);
        //for(Map.Entry<Transaction,String> entry : coordinates.entrySet()) {
            //Transaction t = entry.getKey();
            //String message = entry.getValue();

//            if (message.equals("Facture Déja Payé")) {
//                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
//                        .body("Facture Déja Payé");
//            }
//            else if(message.equals("Montant à payer superieure au montant de la facture"))
//            {
//                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
//                        .body("Montant à payer superieure au montant de la facture");
//            }
//            else if(message.equals("Facture inexistante"))
//            {
//                return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
//                        .body("Facture inexistante");
//            }
        //}
        if(coordinates==null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok().body(coordinates);
    }

    @GetMapping("/deleteTransaction/{id}" )
    public ResponseEntity delete(@PathVariable Long id){
        if(transactionService.deleteById(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/editTransaction/{id}")
    public ResponseEntity editPatient(@RequestBody Transaction transaction, @PathVariable Long id){
        Transaction i= transactionService.findById(id);
        if (i == null){
            return ResponseEntity.notFound().build();
        }
        else if (transaction.getId()==i.getId())
        {
            //Map<Transaction, String> coordinates = transactionService.save(transaction);
            Transaction coordinates = transactionService.save(transaction);
            return ResponseEntity.ok().body(coordinates);
        }
        else
            return ResponseEntity.badRequest().build();
    }
}
