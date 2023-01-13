package org.ms.factureprojetservice.services;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.factureprojetservice.dto.CAparAnnee;
import org.ms.factureprojetservice.dto.StatistiqueClient;
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
import java.util.*;
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

        invoice.setStates("non payée");
        invoice = invoiceRepository.save(invoice);
        return invoice;

    }

    @Override
    public Invoice findById(long id) {

        Invoice invoice = invoiceRepository.findById(id)
                .map(this::addCustomerAndStockItem)
                .orElse(null);
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
        invoice.setStates("payée");
        this.addCustomerAndStockItem(invoice);
        invoiceRepository.save(invoice);
        return invoice;
    }

    @Override
    public Invoice updateInvoiceDate(Long id, Date date) {
        invoiceRepository.updateInvoiceDate(id,date);
        return findById(id);
    }

    @Override
    public Integer findInvoicesByIdProduct(Long id) {
        List<InvoiceLine> all = invoiceLineRepository.findAll();
        List<InvoiceLine> resultats = new ArrayList<>();
        for(InvoiceLine ligne : all)
        {
            if(id== ligne.getStockItemId())
                {
                    resultats.add(ligne);
                }
        }
        return resultats.size();
    }

    @Override
    public Double CAByCustomer(Long id) {
        return invoiceRepository.findInvoicesByCustomerId(id);

    }

    @Override
    public Double ResteApayer(Long id) {
        List<Invoice> all = invoiceRepository.findAll();
        Double amountnotpayed=0.0;
        for(Invoice invoice:all)
        {
            if ("non payée"==invoice.getStates()&&(id==invoice.getCustomerId()))
                amountnotpayed+=invoice.getAmount();

        }
        return amountnotpayed;
    }

    @Override
    public List<Invoice> InvocesByCustomerIdPayed(Long id) {
        List<Invoice> all = invoiceRepository.findAll();
        List<Invoice> result = new ArrayList<>();
        for(Invoice invoice:all)
        {
            if ("payée"==invoice.getStates()&&(id==invoice.getCustomerId()))
                result.add(invoice);

        }
        return result;
    }

    @Override
    public List<Invoice> InvocesByCustomerIdNoPayed(Long id) {
        List<Invoice> all = invoiceRepository.findAll();
        List<Invoice> result = new ArrayList<>();
        for(Invoice invoice:all)
        {
            if ("non payée"==invoice.getStates()&&(id==invoice.getCustomerId()))
                result.add(invoice);

        }
        return result;
    }

    @Override
    public Map<Long, Long> STOCK_ITEMSByCustomerID(Long id) {
        List<Invoice> all = invoiceRepository.findAll();
        Map<Long, Long> result = new HashMap<>();
        for(Invoice invoice:all)
        {
            if (id==invoice.getCustomerId())
            {
                for(InvoiceLine invoiceLine:invoice.getInvoiceLines())
                {

                    Long key = invoiceLine.getStockItemId();
                    if(result.containsKey(key))
                    {
                        Long nb = result.get(key);
                        result.put(key, nb + 1);
                    }
                    else {
                        result.put(key, 1L);
                    }
                }
            }

        }
        return result;
    }

    @Override
    public Map<Long, Double> bestcustomer() {
        Map<Long, Double> result = new HashMap<>();
        List<Customer> allCustumers = clientServiceClient.findAllCustomers();
        List<Double> r = new ArrayList<>();
        List<Long> rr = new ArrayList<>();
        for(Customer customer: allCustumers)
        {
            Long id = customer.getId();
            Double ca = this.CAByCustomer(id);
            r.add(ca);
            rr.add(id);

        }
        for(int i=0; i < r.size(); i++)
        {
            for(int j=1; j < (r.size()-i); j++)
            {
                if(r.get(j - 1) < r.get(j))
                {
                    //echanges des elements
                    Double tmp = r.get(j - 1);
                    r.get(j - 1).equals(r.get(j));
                    r.get(j).equals(tmp);

                    Long tmp1 = rr.get(j - 1);
                    rr.get(j - 1).equals(rr.get(j));
                    rr.get(j).equals(tmp1);


                }

            }
        }

        for(int i=0; i < r.size(); i++)
        {
            result.put(rr.get(i),r.get(i));
        }

        return result;
    }

    @Override
    public List<Map.Entry<Long, Double>> bestcustomer2() {
        List<Map.Entry<Long, Double>> result = new ArrayList<>();
        List<Customer> allCustumers = clientServiceClient.findAllCustomers();
        for(Customer customer: allCustumers)
        {

            Long id = customer.getId();
            Double ca = this.CAByCustomer(id);
            result.add(new AbstractMap.SimpleEntry<>(id, ca));
        }
        result.sort(Comparator.comparingDouble(Map.Entry::getValue));
        return result;
    }
    @Override
    public List<StatistiqueClient> statistique()
    {
        List<Customer> allCustumers = clientServiceClient.findAllCustomers();
        List<StatistiqueClient> statistiqueClient = new ArrayList<>();
        Map<Long, Long> result = new HashMap<>();
        for(Customer customer: allCustumers)
        {
            Long id = customer.getId();
            Double ca = this.CAByCustomer(id);
            Double reste = this.ResteApayer(id);
            result = this.STOCK_ITEMSByCustomerID(id);

            List<Invoice> invoices = this.InvocesByCustomerIdPayed(id);
            List<Invoice> invoices1 = this.InvocesByCustomerIdNoPayed(id);
            Map<Long, Long> produit=this.STOCK_ITEMSByCustomerID(id);

            StatistiqueClient statistiqueClient1=new StatistiqueClient(customer.getCustomerName(),id,ca,reste,invoices,invoices1,produit);
            statistiqueClient.add(statistiqueClient1);

        }
        return statistiqueClient;
    }

    @Override
    public List<CAparAnnee> C_APAR_ANNEES() {
        List<CAparAnnee> cAparAnnees = new ArrayList<>();
        List<Customer> allCustumers = clientServiceClient.findAllCustomers();

        for(Customer customer:allCustumers)
        {
            List<Integer> invoicesYear = invoiceRepository.findAllYearInvoicesByCustomerId(customer.getId());
            for(Integer ann : invoicesYear){
                CAparAnnee cAparAnnee =  new CAparAnnee();
                cAparAnnee.setCutomerids(customer.getId());
                cAparAnnee.setCa(invoiceRepository.findCAAnnInvoicesByCustomerId(customer.getId(),ann));
                cAparAnnee.setYear(ann);
                cAparAnnees.add(cAparAnnee);
            }

        }

        return cAparAnnees;
    }
}
