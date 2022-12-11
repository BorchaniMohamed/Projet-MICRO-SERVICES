package org.ms.produitprojetservice.web;

import lombok.AllArgsConstructor;
import org.ms.produitprojetservice.entities.StockItem;
import org.ms.produitprojetservice.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    @GetMapping("/stockItems")
    private List<StockItem> findAll(){
        List<StockItem> all = productService.findAll();
        return all;
    }

    @GetMapping("/customers/{id}")
    private StockItem findStockItemById(@PathVariable Long id){
        StockItem p = productService.findById(id);
        return p;

    }
    @PostMapping("/customers")
    public StockItem save(@RequestBody StockItem invoice){
        return productService.save(invoice);

    }
    @GetMapping("/deleteCustomer/{id}" )
    public void delete(@PathVariable Long id) throws IOException {
        productService.deleteById(id);
    }

    @GetMapping("/editCustomer/{id}")
    public ResponseEntity<StockItem> editProduct(@RequestBody StockItem p, @PathVariable Long id){
        StockItem i= productService.findById(id);
        if (i == null){
            return ResponseEntity.notFound().build();
        }
        else if (p.getId()==i.getId())
        {
            i= productService.save(p);
            return ResponseEntity.ok().body(i);
        }
        else
            return ResponseEntity.badRequest().build();
    }
}
