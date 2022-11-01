package org.ms.factureprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.entities.InvoiceLine;
import org.ms.factureprojetservice.feign.ClientServiceClient;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.model.customer.Customer;
import org.ms.factureprojetservice.model.stockItem.StockItem;
import org.ms.factureprojetservice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    InvoiceRepository invoiceRepository;
    private ClientServiceClient clientServiceClient;
    private ProduitServiceClient produitServiceClient;

    @Override
    public boolean deleteById(Long id) {
        if(invoiceRepository.existsById(id)){invoiceRepository.deleteById(id); return true;}
        return false;
    }

    @Override
    public Invoice save(Invoice invoice) {

         invoice = invoiceRepository.save(invoice);
         invoice = this.addCustomerAndStockItem(invoice);
         invoice.setAmount(this.computeAmount(invoice));
        invoice = invoiceRepository.save(invoice);
         return invoice;

    }

    @Override
    public Invoice findById(long id) {

        return invoiceRepository.findById(id)
                .map(this::addCustomerAndStockItem)
                .orElse(null);


    }

    @Override
    public List<Invoice> findAll() {
        return invoiceRepository.findAll()
                .stream()
                .map(this::addCustomerAndStockItem)
                .collect(Collectors.toList());
    }

    @Override
    public Invoice addCustomerAndStockItem(Invoice invoice) {

        Customer client = clientServiceClient.findClientById(invoice.getCustomerId());
        invoice.setCustomer(client);
        invoice.getInvoiceLines().forEach(invoiceLine -> {
            StockItem stockitem = produitServiceClient.findProductById(invoiceLine.getStockItemId());
            invoiceLine.setStockItem(stockitem);
        });
        return invoice;
    }

    @Override
    public Double computeAmount(Invoice invoice) {
        double total =0.0;
        for(InvoiceLine i : invoice.getInvoiceLines() ){
            total = total+ i.getStockItem().getPrice()* i.getQuantity();
        }
        return total;
    }

}
