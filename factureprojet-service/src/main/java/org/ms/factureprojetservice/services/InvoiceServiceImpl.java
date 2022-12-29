package org.ms.factureprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.entities.InvoiceLine;
import org.ms.factureprojetservice.feign.ClientServiceClient;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.model.customer.Customer;
import org.ms.factureprojetservice.model.stockItem.StockItem;
import org.ms.factureprojetservice.repository.InvoiceLineRepository;
import org.ms.factureprojetservice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Slf4j
public class InvoiceServiceImpl implements InvoiceService {
    private InvoiceRepository invoiceRepository;
    private ClientServiceClient clientServiceClient;
    private ProduitServiceClient produitServiceClient;
//    private TransactionServiceClient transactionServiceClient;
    private InvoiceLineRepository invoiceLineRepository;

    @Override
    public void deleteById(Long id) throws IOException {
        invoiceRepository.deleteById(id);
    }

    @Override
    public Invoice save(Invoice invoice) {
         invoice = invoiceRepository.save(invoice);
         invoice = this.addCustomerAndStockItem(invoice);
         invoice.setAmount(this.computeAmount(invoice));
         Date date = new Date();
         invoice.setInvoiceDate(date);
        for (InvoiceLine invoiceLine : invoice.getInvoiceLines()) {

            invoiceLineRepository.save(invoiceLine);
            invoiceLine.setInvoice(invoice);
        }
        invoice = invoiceRepository.save(invoice);

        invoice.setStates("Non payé");
        invoice = invoiceRepository.save(invoice);
        return invoice;

    }

    @Override
    public Invoice findById(long id) {

        Invoice invoice = invoiceRepository.findById(id)
                .map(this::addCustomerAndStockItem)
                .orElse(null);
//        if((invoice!=null)&&(invoice.getAmount()!=null)) {
//            Double y = this.computeAmountTransaction(invoice);
//            if (y == null) return invoice;
//            else
//            {
//               invoice.setRestetopayed(invoice.getAmount()-y);
//                this.save(invoice);
//                return invoice;
//            }
//        }
        //else return invoice;
        return invoice;
    }

    @Override
    public List<Invoice> findAll() {
        List<Invoice> allLInvoice= invoiceRepository.findAll()
                .stream()
                .map(this::addCustomerAndStockItem)
                .collect(Collectors.toList());
        return allLInvoice;
    }

    @Override
    public Invoice addCustomerAndStockItem(Invoice invoice) {

        Customer client = clientServiceClient.findClientById(invoice.getCustomerId());
        invoice.setCustomer(client);
        invoice.getInvoiceLines().forEach(invoiceLine -> {
            StockItem stockitem = produitServiceClient.findProductById(invoiceLine.getStockItemId());
            invoiceLine.setStockItem(stockitem);
            invoiceLine.setAmountinvoiveline(stockitem.getPrice()*invoiceLine.getQuantity());
            invoiceLineRepository.save(invoiceLine);
        });
        return invoice;
    }

    @Override
    public Double computeAmount(Invoice invoice) {
        double total =0.0;
        for(InvoiceLine invoiceLine : invoice.getInvoiceLines() ){
            total = total+ invoiceLine.getAmountinvoiveline();
        }
        return total;
    }



    @Override
    public List<Invoice> findNewInvoice() {
        List<Invoice> all = invoiceRepository.findAll();
        List<Invoice> listejour = new ArrayList<>();
        Date date = new Date();
        int y = date.getYear(); int m = date.getMonth(); int j = date.getDay();
        for(Invoice i : all)
        {
            Date dateinvoice = i.getInvoiceDate();
            if(dateinvoice != null)
            {
                int y_invoice = dateinvoice.getYear();int m_invoice = dateinvoice.getMonth();int j_invoice = dateinvoice.getDay();
                if ((y == y_invoice) && (m == m_invoice) && (j == j_invoice)) {listejour.add(i);}
            }
        }
        return listejour;
    }

    @Override
    public Invoice updateStatutFacture(Long id) {
        Invoice invoice=invoiceRepository.getById(id);
        invoice.setStates("Payé");
        this.addCustomerAndStockItem(invoice);
        invoiceRepository.save(invoice);
        return invoice;
    }
}
