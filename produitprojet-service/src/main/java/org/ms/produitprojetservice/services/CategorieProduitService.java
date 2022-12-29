package org.ms.produitprojetservice.services;

import org.ms.produitprojetservice.entities.StockItemCategory;

import java.io.IOException;
import java.util.List;

public interface CategorieProduitService {
    void deleteById(Long id) throws IOException;
    StockItemCategory save(StockItemCategory stockItemCategory);
    StockItemCategory findById(long id);
    List<StockItemCategory> findAll();
}
