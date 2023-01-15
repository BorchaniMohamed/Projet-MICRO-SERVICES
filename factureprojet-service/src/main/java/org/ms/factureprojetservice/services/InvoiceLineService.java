package org.ms.factureprojetservice.services;

import org.ms.factureprojetservice.entities.InvoiceLine;

import java.io.IOException;
import java.util.List;

public interface InvoiceLineService {
    void deleteById(Long id) throws IOException;
    InvoiceLine save(InvoiceLine invoiceLine);
    InvoiceLine findById(Long id);
    List<InvoiceLine> findAll();

    Integer findInvoiceLineByStockItemId();
}
