package org.ms.payementprojetservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.payementprojetservice.entities.Transaction;
import org.ms.payementprojetservice.services.TransactionService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class TransactionController {

    private TransactionService transactionService;


    @GetMapping("/transactions")
    private List<Transaction> findAll(){
        List<Transaction> all = transactionService.findAll();
        return all;
    }
    @GetMapping("/transactions/{id}")
    private Transaction findTransactionById(@PathVariable Long id){
        return transactionService.findById(id);
    }

    @PostMapping("/transactions/{montantdevise}")
    public Transaction save(@RequestBody Transaction transaction,@PathVariable Double montantdevise){
        return transactionService.save(transaction,montantdevise);
    }

    @GetMapping("/deleteTransaction/{id}" )
    public void delete(@PathVariable Long id) throws IOException {
        transactionService.deleteById(id);
    }
    @GetMapping("/editTransaction/{id}")
    public Transaction editTransaction(@RequestBody Transaction transaction, @PathVariable Long id){
        return null;
    }

    @GetMapping("newtransactions")
    public List<Transaction> newtransactions(){
        return transactionService.findTransactionsByTransactionDate();
    }
}
