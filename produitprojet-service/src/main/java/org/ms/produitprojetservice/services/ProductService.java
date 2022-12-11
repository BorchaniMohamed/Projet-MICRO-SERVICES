package org.ms.produitprojetservice.services;

import org.ms.produitprojetservice.entities.StockItem;

import java.io.IOException;
import java.util.List;

public interface ProductService {
    void deleteById(Long id) throws IOException;
    StockItem save(StockItem customer);
    StockItem findById(long id);
    List<StockItem> findAll();
}
