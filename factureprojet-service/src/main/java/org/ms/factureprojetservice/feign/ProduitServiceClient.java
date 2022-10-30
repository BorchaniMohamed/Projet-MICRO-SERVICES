package org.ms.factureprojetservice.feign;

import org.ms.factureprojetservice.model.stockItem.StockItem;
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
