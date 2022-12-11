package org.ms.payementprojetservice.feign;

import org.ms.payementprojetservice.entities.Invoce.Invoice;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="FACTUREPROJET-SERVICE")
public interface FactureServiceClient {

    @GetMapping(path="/invoices")
    PagedModel<Invoice> findAll();
    @GetMapping(path="/invoices/{id}")
    Invoice findInvoiceById(@PathVariable(name="id")Long id);
}
