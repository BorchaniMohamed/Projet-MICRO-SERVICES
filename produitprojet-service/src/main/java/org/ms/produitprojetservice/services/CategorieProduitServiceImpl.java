package org.ms.produitprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.produitprojetservice.entities.StockItemCategory;
import org.ms.produitprojetservice.repository.StockItemCategoryRepository;
import org.ms.produitprojetservice.repository.StockItemRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
@AllArgsConstructor
public class CategorieProduitServiceImpl implements CategorieProduitService{
    private StockItemCategoryRepository stockItemCategoryRepository;
    private StockItemRepository stockItemRepository;
    @Override
    public void deleteById(Long id) throws IOException {
        stockItemCategoryRepository.deleteById(id);
    }

    @Override
    public StockItemCategory save(StockItemCategory stockItemCategory) {
        return stockItemCategoryRepository.save(stockItemCategory);
    }

    @Override
    public StockItemCategory findById(long id) {
        return stockItemCategoryRepository.getById(id);
    }

    @Override
    public List<StockItemCategory> findAll() {
        return stockItemCategoryRepository.findAll();
    }
}
