package org.ms.factureprojetservice.services;

import org.ms.factureprojetservice.entities.Invoice;

import java.util.List;


public interface InvoiceService {
    boolean deleteById(Long id);

    Invoice save(Invoice invoice);

    Invoice findById(long id);

    List<Invoice> findAll();

    Invoice addCustomerAndStockItem(Invoice invoice);

    Double computeAmount (Invoice invoice);
}
