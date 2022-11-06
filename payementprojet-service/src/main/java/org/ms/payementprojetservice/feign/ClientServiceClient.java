package org.ms.payementprojetservice.feign;

import org.ms.payementprojetservice.entities.customer.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="CLIENTPROJET-SERVICE")


    public interface ClientServiceClient {
        @GetMapping(path="/customers/{id}")
        Customer findClientById(@PathVariable(name="id") Long id);
    }

