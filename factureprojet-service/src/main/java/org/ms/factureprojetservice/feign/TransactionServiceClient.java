package org.ms.factureprojetservice.feign;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PAYEMENTPROJET-SERVICE")
public interface TransactionServiceClient {
    @GetMapping(path="transactions/facture/{id}")
    Double findTransactionsByInvoice_id(@PathVariable(name="id") Long id);
}
