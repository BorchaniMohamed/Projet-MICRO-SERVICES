package org.ms.factureprojetservice.services;

import org.ms.factureprojetservice.entities.Invoice;

import java.io.IOException;
import java.util.List;


public interface InvoiceService {
    void deleteById(Long id) throws IOException;
    Invoice save(Invoice invoice);
    Invoice findById(long id);
    List<Invoice> findAll();
    Invoice addCustomerAndStockItem(Invoice invoice);
    Double computeAmount (Invoice invoice);
    //Double computeAmountTransaction (Invoice invoice);
    List<Invoice> findNewInvoice();
    Invoice updateStatutFacture (Long id);

}
