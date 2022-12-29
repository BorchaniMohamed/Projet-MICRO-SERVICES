package org.ms.produitprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.produitprojetservice.entities.Fournisseur;
import org.ms.produitprojetservice.entities.StockItem;
import org.ms.produitprojetservice.entities.StockItemCategory;
import org.ms.produitprojetservice.repository.FournisseurRepository;
import org.ms.produitprojetservice.repository.StockItemCategoryRepository;
import org.ms.produitprojetservice.repository.StockItemRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductServiceImpl implements ProductService{
    private StockItemCategoryRepository stockItemCategoryRepository;
    private StockItemRepository stockItemRepository;
    private FournisseurRepository fournisseurRepository;

    @Override
    public void deleteById(Long id) throws IOException {
        stockItemRepository.deleteById(id);
    }

    @Override
    public StockItem save(StockItem stockItem) {
        //fournisseurRepository.save(stockItem.getFournisseur());
        Fournisseur fournisseur=fournisseurRepository.getById(stockItem.getFournisseur().getId());
        StockItemCategory stockItemCategory=stockItemCategoryRepository.getById(stockItem.getCategorie().getId());
        stockItem.setCategorie(stockItemCategory);
        stockItem.setFournisseur(fournisseur);
        return stockItemRepository.save(stockItem);
    }

    @Override
    public StockItem findById(long id) {
        return stockItemRepository.findById(id).get();
    }

    @Override
    public List<StockItem> findAll() {
        return stockItemRepository.findAll();
    }

    @Override
    public StockItem update(StockItem stockItem) {
        Fournisseur fournisseur = fournisseurRepository.getById(stockItem.getFournisseur().getId());
        log.info(fournisseur.toString());
//        fournisseur.setEmail(stockItem.getFournisseur().getEmail());
//        fournisseur.setTelephone(stockItem.getFournisseur().getTelephone());
//        fournisseur.setNomfournissuer(stockItem.getFournisseur().getNomfournissuer());
//        fournisseur.setAccountOpenedDate(stockItem.getFournisseur().getAccountOpenedDate());

        StockItemCategory stockItemCategory=stockItemCategoryRepository.getById(stockItem.getCategorie().getId());
//        stockItemCategory.setStockItemCategoryName(stockItem.getCategorie().getStockItemCategoryName());
        stockItem.setCategorie(stockItemCategory);
        stockItem.setFournisseur(fournisseur);
//        log.info(stockItem.toString());
        stockItemRepository.save(stockItem);
        log.info(stockItem.toString());

        return stockItem;
    }

    @Override
    public List<StockItem> findNewStockItem() {
        Date date1=new Date();
        return stockItemRepository.findStockItemsByAccountOpenedDate(date1);
    }

    @Override
    public StockItem updatePrix(Long id, Integer qteCommde) {
        StockItem stockItem = stockItemRepository.getById(id);
        if (stockItem != null)
        {
            stockItem.setQuantity(stockItem.getQuantity()-qteCommde);
        }
        return stockItemRepository.save(stockItem);
    }
}
