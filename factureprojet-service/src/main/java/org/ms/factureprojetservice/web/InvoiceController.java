package org.ms.factureprojetservice.web;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.ms.factureprojetservice.dto.CAparAnnee;
import org.ms.factureprojetservice.dto.RangProduit;
import org.ms.factureprojetservice.dto.StatistiqueClient;
import org.ms.factureprojetservice.entities.Invoice;
import org.ms.factureprojetservice.entities.InvoiceLine;
import org.ms.factureprojetservice.feign.ClientServiceClient;
import org.ms.factureprojetservice.feign.ProduitServiceClient;
import org.ms.factureprojetservice.services.InvoiceLineService;
import org.ms.factureprojetservice.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("http://localhost:4200")
@AllArgsConstructor
@Slf4j
public class InvoiceController {

    private InvoiceLineService invoiceLineService;
    private InvoiceService invoiceService;
    private ClientServiceClient clientServiceClient;
    private ProduitServiceClient produitServiceClient;


    @GetMapping("/invoices")
    private List<Invoice> findAllinvoice(){
        List<Invoice> all = invoiceService.findAll();
        return all;
    }

    @GetMapping("/invoicesLine")
    private List<InvoiceLine> findAllinvoiceLine(){
        return invoiceLineService.findAll();
    }

    @GetMapping("/invoices/{id}")
    private Invoice findInvoiceById(@PathVariable Long id){
        Invoice invoice = invoiceService.findById(id);
        return invoice;
    }

    @GetMapping("/newinvoices")
    private List<Invoice> findNewInvoices(){
        List<Invoice> newall = invoiceService.findNewInvoice();
        return newall;
    }

    @GetMapping("invoicesligne/{idinvoiceline}")
    private void findInvoiceLineByIdinvoice(@PathVariable Long idinvoiceline) throws IOException{
        invoiceLineService.deleteById(idinvoiceline);
    }
    @PostMapping("/invoices")
    public Invoice save(@RequestBody Invoice invoice){
        return invoiceService.save(invoice);

    }
    @GetMapping("/deleteInvoice/{id}" )
    public void deleteInvoice(@PathVariable Long id) throws IOException {
        invoiceService.deleteById(id);
    }

    @GetMapping("deleteinvoiceline/{idinvoiceline}")
    public void deleteInvoiceLine (@PathVariable Long idinvoiceline) throws IOException{
        invoiceLineService.deleteById(idinvoiceline);
    }



    @PutMapping("/editInvoice/{id}")
    public Invoice editInvoice(@PathVariable Long id){
        Invoice invoice = invoiceService.findById(id);
        invoice.setStates("payée");
        return invoice;
    }

    @GetMapping("/editinvoicestatu/{id}")
    public Invoice editInvoiveStatut(@PathVariable Long id){
        return invoiceService.updateStatutFacture(id);
    }

    @GetMapping("/nombreInvoicesByProduct/{id}")
    public Integer nbInvoicesByProduct(@PathVariable Long id)
    {
        return invoiceService.findInvoicesByIdProduct(id);
    }

    @GetMapping("cabycustomer/{id}")
    public Double CaByCustomer(@PathVariable Long id)
    {return invoiceService.CAByCustomer(id);}

    @GetMapping("invoicesbycustomerpayed/{id}")
    public List<Invoice> invoicesbycustomerpayed(@PathVariable Long id)
    {return invoiceService.InvocesByCustomerIdPayed(id);}

    @GetMapping("invoicesbycustomernonpayed/{id}")
    public List<Invoice> invoicesbycustomernonpayed(@PathVariable Long id)
    {return invoiceService.InvocesByCustomerIdNoPayed(id);}

    @GetMapping("cabycustomernonpayed/{id}")
    public Double CAByInvoiceState(@PathVariable Long id)
    {
        System.out.println("#######################################################");
        Double nonPaye = invoiceService.ResteApayer(id);
        System.out.println(nonPaye);
        return nonPaye;
    }

    @GetMapping("stockItembycustomer/{id}")
    public Map<String, Long> stockItembycustomer(@PathVariable Long id)
    {return invoiceService.STOCK_ITEMSByCustomerID(id);}



    @GetMapping("bestcustomer2")
    public  List<Map.Entry<Long, Double>> bestcustomer2()
    {return invoiceService.bestcustomer2();}

    @GetMapping("statistiqueclient")
    public List<StatistiqueClient> statistiqueclient()
    {return invoiceService.statistique();}

    @GetMapping("caparanneparclient")
    public List<CAparAnnee> caparanneparclient()
    {return invoiceService.C_APAR_ANNEES();}

    @GetMapping("updateDateFacture")
    public Invoice updateDateFacture(@PathVariable Long id,@PathVariable Date date)
    {return invoiceService.updateInvoiceDate(id,date);}

    @GetMapping("ragproduit")
    public List<RangProduit> rangProduits ()
    {return invoiceService.rangproduit();}
    @GetMapping("ragproduit2")
    public List<RangProduit> rangProduits2 ()
    {return invoiceService.rangproduit2();}

    @GetMapping("chiffreaffaire")
    public Double chiffreaffaire ()
    {return invoiceService.chiffreaffaire();}

    @GetMapping("dettesclients")
    public Double dettesclients ()
    {return invoiceService.dettesclients();}

    @GetMapping("clientnonactif")
    public Integer clientnonactif ()
    {return invoiceService.clientnonactifs();}

    @GetMapping("produitpassif")
    public Integer produitpassif ()
    {return invoiceLineService.findInvoiceLineByStockItemId();}

}
