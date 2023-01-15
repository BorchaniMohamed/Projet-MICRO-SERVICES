package org.ms.produitprojetservice.web;

import lombok.AllArgsConstructor;
import org.ms.produitprojetservice.entities.Fournisseur;
import org.ms.produitprojetservice.entities.StockItem;
import org.ms.produitprojetservice.entities.StockItemCategory;
import org.ms.produitprojetservice.services.CategorieProduitService;
import org.ms.produitprojetservice.services.FournisseurService;
import org.ms.produitprojetservice.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private FournisseurService fournisseurService;
    private CategorieProduitService categorieProduitService;
    @GetMapping("/stockItems")
    private List<StockItem> findAll(){
        List<StockItem> all = productService.findAll();
        return all;
    }

    @GetMapping("/listeproduitsenrepture")
    private List<StockItem> listeproduitsenrepture(){
        return productService.produitrepturestock();
    }
    @GetMapping("/newstockItems")
    private List<StockItem> findNewstockItems(){
        List<StockItem> all = productService.findNewStockItem();
        return all;
    }
    @GetMapping("/newcFournisseurs")
    private List<Fournisseur> findNewFournisseurs(){
        List<Fournisseur> all = fournisseurService.findNewFournisseus();
        return all;
    }

    @GetMapping("/stockItemCategories")
    private List<StockItemCategory> findAllCategory(){
        List<StockItemCategory> all = categorieProduitService.findAll();
        return all;
    }

    @GetMapping("/fournisseurs")
    private List<Fournisseur> findAllAdresses(){
        List<Fournisseur> all = fournisseurService.findAll();
        return all;
    }

    @GetMapping("/produitsrepture")
    private Integer produitsrepture(){
        return productService.produitrepture();

    }



    @GetMapping("/fournisseurs/{id}")
    private Fournisseur findFournisseurById(@PathVariable Long id){
        Fournisseur fournisseur = fournisseurService.findById(id);
        return fournisseur;
    }

    @GetMapping("/stockItemCategories/{id}")
    private StockItemCategory findStockItemCategorieById(@PathVariable Long id){
        StockItemCategory stockItemCategory = categorieProduitService.findById(id);
        return stockItemCategory;
    }

    @GetMapping("/stockItems/{id}")
    private StockItem findStockItemById(@PathVariable Long id){
        StockItem stockItem = productService.findById(id);
        return stockItem;
    }
    @PostMapping("/fournisseurs")
    public Fournisseur save(@RequestBody Fournisseur fournisseur){
        return fournisseurService.save(fournisseur);
    }
    @PostMapping("/stockItemCategories")
    public StockItemCategory save(@RequestBody StockItemCategory stockItemCategory){
        return categorieProduitService.save(stockItemCategory);
    }
    @PostMapping("/stockItems")
    public StockItem save(@RequestBody StockItem stockItem){
        return productService.save(stockItem);
    }



    @GetMapping("/deleteStockItem/{id}" )
    public void deleteStockItem(@PathVariable Long id) throws IOException {
        productService.deleteById(id);
    }
    @GetMapping("/deleteStockItemCategorie/{id}" )
    public void deleteStockItemCategorie(@PathVariable Long id) throws IOException {
        categorieProduitService.deleteById(id);
    }
    @GetMapping("/deleteFournisseur/{id}" )
    public void deleteFournisseur(@PathVariable Long id) throws IOException {
        fournisseurService.deleteById(id);
    }

    @PutMapping("stockItems/{stockItemid}")
    public StockItem editStockItem(@PathVariable Long stockItemid,@RequestBody StockItem stockItem){
        stockItem.setId(stockItemid);
        return productService.update(stockItem);
    }
    @GetMapping("stockItems/{stockItemid}/{qteCommande}")
    public StockItem editStockItemPrix(@PathVariable Long stockItemid,@PathVariable Integer qteCommande){
        return productService.updatePrix(stockItemid,qteCommande);
    }

    @PutMapping("stockItemsCategorie/{stockItemCategorieid}")
    public StockItemCategory editStockItemCategorie(@PathVariable Long stockItemCategorieid,@RequestBody StockItemCategory stockItemCategory){
        stockItemCategory.setId(stockItemCategorieid);
        return categorieProduitService.save(stockItemCategory);
    }
    @PutMapping("fournisseurs/{fournisseurid}")
    public Fournisseur editFournisseur(@PathVariable Long fournisseurid,@RequestBody Fournisseur fournisseur){
        fournisseur.setId(fournisseurid);
        return fournisseurService.save(fournisseur);
    }
}
