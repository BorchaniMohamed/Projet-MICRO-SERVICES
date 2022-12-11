package org.ms.factureprojetservice.services;

import lombok.AllArgsConstructor;
import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.entities.InvoiceLine;
import org.ms.factureprojetservice.feign.ClientServiceClient;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.feign.TransactionServiceClient;
import org.ms.factureprojetservice.model.customer.Customer;
import org.ms.factureprojetservice.model.stockItem.StockItem;
import org.ms.factureprojetservice.repository.InvoiceLineRepository;
import org.ms.factureprojetservice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ClientServiceClient clientServiceClient;
    private ProduitServiceClient produitServiceClient;
    private TransactionServiceClient transactionServiceClient;
    private InvoiceLineRepository invoiceLineRepository;

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
        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()) {

            invoiceLineRepository.save(invoiceLine);
            invoiceLine.setInvoice(invoice);
        }
        invoice = invoiceRepository.save(invoice);
        invoice.setStates("created");
        invoice.setRestetopayed(invoice.getAmount()-this.computeAmountTransaction(invoice));
        invoice = invoiceRepository.save(invoice);
         return invoice;

    }

    @Override
    public Invoice findById(long id) {

        Invoice i = invoiceRepository.findById(id)
                .map(this::addCustomerAndStockItem)
                .orElse(null);
        if((i!=null)&&(i.getAmount()!=null)) {
            Double y = this.computeAmountTransaction(i);
            if (y == null) return i;
            else
            {
                i.setRestetopayed(i.getAmount()-y);
                this.save(i);
                return i;
            }
        }
        else return i;
    }

    @Override
    public List<Invoice> findAll() {
        List<Invoice> allLInvoice= invoiceRepository.findAll()
                .stream()
                .map(this::addCustomerAndStockItem)
                .collect(Collectors.toList());
        for(Invoice i : allLInvoice)
        {
            Double y=this.computeAmountTransaction(i);
            if((y!=null) && (i.getAmount()!=null))
            {
                i.setRestetopayed(i.getAmount()-y);
                this.save(i);
            }
        }
        return allLInvoice;
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

    @Override
    public Double computeAmountTransaction(Invoice invoice) {
        Double x = transactionServiceClient.findTransactionsByInvoice_id(invoice.getId());
        if (x==null) {
            return 0.0;
        }
        else return x;

//        else {
//            return transactionServiceClient.findTransactionsByInvoice_id(invoice.getId())
//                    .stream()
//                    .map(Transaction::getAmount)
//                    .reduce(Double::sum)
//                    .orElse(0.0);
//        }

    }

}
