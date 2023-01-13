package org.ms.factureprojetservice.services;

import org.ms.factureprojetservice.dto.CAparAnnee;
import org.ms.factureprojetservice.dto.StatistiqueClient;
import org.ms.factureprojetservice.entities.Invoice;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


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
    Invoice updateInvoiceDate (Long id, Date date);
    Integer findInvoicesByIdProduct(Long id);

    Double CAByCustomer(Long id);
    Double ResteApayer(Long id);
    List<Invoice> InvocesByCustomerIdPayed(Long id);
    List<Invoice> InvocesByCustomerIdNoPayed(Long id);

    Map<Long,Long> STOCK_ITEMSByCustomerID(Long id);

    Map<Long,Double> bestcustomer();
    List<Map.Entry<Long,Double>> bestcustomer2();

    List<StatistiqueClient> statistique();

    List<CAparAnnee> C_APAR_ANNEES();

//    List<ChiffreAffaireParClient> chiffreAffaireClient(Long id);

}
