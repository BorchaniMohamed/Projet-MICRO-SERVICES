package org.ms.produitprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.produitprojetservice.entities.StockItem;
import org.ms.produitprojetservice.entities.StockItemCategory;
import org.ms.produitprojetservice.repository.StockItemCategoryRepository;
import org.ms.produitprojetservice.repository.StockItemRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService{
    private StockItemCategoryRepository stockItemCategory;
    private StockItemRepository stockItemRepository;

    @Override
    public void deleteById(Long id) throws IOException {
        try
        {
            stockItemRepository.deleteById(id);
        }
        catch (Exception e)
        {
            System.out.println("Produit n'existe pas");
        }
    }

    @Override
    public StockItem save(StockItem customer) {
        return stockItemRepository.save(customer);
    }

    @Override
    public StockItem findById(long id) {
        return stockItemRepository.findById(id).get();
    }

    @Override
    public List<StockItem> findAll() {
        return stockItemRepository.findAll();
    }
}
