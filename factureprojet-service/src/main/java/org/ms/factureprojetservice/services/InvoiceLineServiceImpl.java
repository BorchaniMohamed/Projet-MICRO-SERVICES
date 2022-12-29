package org.ms.factureprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.factureprojetservice.entities.InvoiceLine;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.repository.InvoiceLineRepository;
import org.ms.factureprojetservice.repository.InvoiceRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class InvoiceLineServiceImpl implements InvoiceLineService{
    private InvoiceLineRepository invoiceLineRepository;
    private InvoiceRepository invoiceRepository;
    private ProduitServiceClient produitServiceClient;

    @Override
    public void deleteById(Long id) throws IOException {
        invoiceLineRepository.deleteById(id);
    }

    @Override
    public InvoiceLine save(InvoiceLine invoiceLine) {
//        StockItem stockitem = produitServiceClient.findProductById(invoiceLine.getStockItemId());
//        invoiceLine.setStockItem(stockitem);
//        System.out.println(stockitem.getPrice());
       // invoiceLine.setAmountinvoiveline(stockitem.getPrice()*invoiceLine.getQuantity());
        //System.out.println(invoiceLine.getAmountinvoiveline());
        return invoiceLineRepository.save(invoiceLine);
    }

    @Override
    public InvoiceLine findById(Long id) {
        return invoiceLineRepository.findById(id).get();
    }

    @Override
    public List<InvoiceLine> findAll() {
        return invoiceLineRepository.findAll();
    }

}
