package org.ms.payementprojetservice.feign;

import org.ms.payementprojetservice.entities.StockItems.StockItem;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="PRODUITPROJET-SERVICE")
public interface ProduitServiceClient {

    @GetMapping(path="/stockItems")
    PagedModel<StockItem> getAllProduits();
    @GetMapping(path="/stockItems/{id}")
    StockItem findProductById(@PathVariable(name="id")Long id);
}
