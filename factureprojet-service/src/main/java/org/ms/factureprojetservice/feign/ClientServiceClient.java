package org.ms.factureprojetservice.feign;

import org.ms.factureprojetservice.model.customer.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="CLIENTPROJET-SERVICE")
public interface ClientServiceClient {
    @GetMapping(path="/customers/{id}")
    Customer findClientById(@PathVariable(name="id") Long id);

    @GetMapping("/customers")
    List<Customer> findAllCustomers();

}
