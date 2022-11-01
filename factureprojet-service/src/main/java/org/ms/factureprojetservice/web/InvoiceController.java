package org.ms.factureprojetservice.web;

import lombok.AllArgsConstructor;
import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.feign.ClientServiceClient;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.repository.InvoiceLineRepository;
import org.ms.factureprojetservice.services.InvoiceService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class InvoiceController {

    private InvoiceLineRepository invoiceLineRepository;
    private InvoiceService invoiceService;
    private ClientServiceClient clientServiceClient;
    private ProduitServiceClient produitServiceClient;


    @GetMapping("/invoices")
    private List<Invoice> findAll(){
        List<Invoice> all = invoiceService.findAll();
        return all;
    }
    @GetMapping("/invoices/{id}")
    private Invoice findInvoiceById(@PathVariable Long id){
        Invoice invoice = invoiceService.findById(id);
        return invoice;

    }
    @PostMapping("/invoices")
    public Invoice save(@RequestBody Invoice invoice){
        return invoiceService.save(invoice);

    }
    @GetMapping("/deleteInvoice/{id}" )
    public ResponseEntity delete(@PathVariable Long id){
        if(invoiceService.deleteById(id))
            return ResponseEntity.ok().build();
        return ResponseEntity.notFound().build();
    }
    @GetMapping("/editInvoice/{id}")
    public ResponseEntity<Invoice> editPatient(@RequestBody Invoice invoice, @PathVariable Long id){
        Invoice i= invoiceService.findById(id);
        if (i == null){
            return ResponseEntity.notFound().build();
        }
        else if (invoice.getId()==i.getId())
        {
            i= invoiceService.save(invoice);
            return ResponseEntity.ok().body(i);
        }
        else
            return ResponseEntity.badRequest().build();
    }


}
