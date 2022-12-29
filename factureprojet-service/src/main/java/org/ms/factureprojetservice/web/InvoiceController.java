package org.ms.factureprojetservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.entities.InvoiceLine;
import org.ms.factureprojetservice.feign.ClientServiceClient;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.services.InvoiceLineService;
import org.ms.factureprojetservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class InvoiceController {

    private InvoiceLineService invoiceLineService;
    private InvoiceService invoiceService;
    private ClientServiceClient clientServiceClient;
    private ProduitServiceClient produitServiceClient;


    @GetMapping("/invoices")
    private List<Invoice> findAllinvoice(){
        List<Invoice> all = invoiceService.findAll();
        return all;
    }

    @GetMapping("/invoicesLine")
    private List<InvoiceLine> findAllinvoiceLine(){
        return invoiceLineService.findAll();
    }

    @GetMapping("/invoices/{id}")
    private Invoice findInvoiceById(@PathVariable Long id){
        Invoice invoice = invoiceService.findById(id);
        return invoice;
    }

    @GetMapping("/newinvoices")
    private List<Invoice> findNewInvoices(){
        List<Invoice> newall = invoiceService.findNewInvoice();
        return newall;
    }

    @GetMapping("invoicesligne/{idinvoiceline}")
    private void findInvoiceLineByIdinvoice(@PathVariable Long idinvoiceline) throws IOException{
        invoiceLineService.deleteById(idinvoiceline);
    }
    @PostMapping("/invoices")
    public Invoice save(@RequestBody Invoice invoice){
        return invoiceService.save(invoice);

    }
    @GetMapping("/deleteInvoice/{id}" )
    public void deleteInvoice(@PathVariable Long id) throws IOException {
        invoiceService.deleteById(id);
    }

    @GetMapping("deleteinvoiceline/{idinvoiceline}")
    public void deleteInvoiceLine (@PathVariable Long idinvoiceline) throws IOException{
        invoiceLineService.deleteById(idinvoiceline);
    }



    @PutMapping("/editInvoice/{id}")
    public Invoice editInvoice(@PathVariable Long id){
        Invoice invoice = invoiceService.findById(id);
        invoice.setStates("payé");
        return invoice;
    }

    @GetMapping("/editinvoicestatu/{id}")
    public Invoice editInvoiveStatut(@PathVariable Long id){
        return invoiceService.updateStatutFacture(id);
    }
}
