package org.ms.factureprojetservice.web;

import lombok.AllArgsConstructor;
import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.feign.ClientServiceClient;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.model.customer.Customer;
import org.ms.factureprojetservice.model.stockItem.StockItem;
import org.ms.factureprojetservice.repository.InvoiceLineRepository;
import org.ms.factureprojetservice.repository.InvoiceRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class InvoiceController {

    private InvoiceLineRepository invoiceLineRepository;
    private InvoiceRepository invoiceRepository;
    private ClientServiceClient clientServiceClient;
    private ProduitServiceClient produitServiceClient;

    @GetMapping("/invoices")
    private List<Invoice> findAll(){
        List<Invoice> all = invoiceRepository.findAll();
        all.forEach(invoice -> {
            Customer client = clientServiceClient.findClientById(invoice.getCustomerId());
            invoice.setCustomer(client);
            invoice.getInvoiceLines().forEach(invoiceLine -> {
                StockItem stockitem = produitServiceClient.findProductById(invoiceLine.getStockItemId());
                invoiceLine.setStockItem(stockitem);
            });
        });

        return all;
    }
    @GetMapping("/invoices/{id}")
    private Invoice findInvoiceById(@PathVariable Long id){
        Invoice invoice = invoiceRepository.getById(id);
        Customer client = clientServiceClient.findClientById(invoice.getCustomerId());
        invoice.setCustomer(client);
        invoice.getInvoiceLines().forEach(invoiceLine -> {
            StockItem stockitem = produitServiceClient.findProductById(invoiceLine.getStockItemId());
            invoiceLine.setStockItem(stockitem);
        });
        return invoice;

    }


}
