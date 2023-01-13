package org.ms.factureprojetservice.repository;

import org.ms.factureprojetservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Date;
import java.util.List;

//@RepositoryRestController
@RepositoryRestController
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    @Query("select sum(i.amount) as CA from Invoice i where i.customerId = ?1")
    Double findInvoicesByCustomerId(Long id);

    @Query("select sum(i.amount) as CA from Invoice i where i.customerId = ?1 and year(i.invoiceDate) = ?2")
    Double findCAAnnInvoicesByCustomerId(Long id,Integer year);

    @Query("select i from Invoice i where i.customerId = ?1 and Year(i.invoiceDate) = ?2")
    List<Invoice> findAllInvoicesByCustomerId(Long id,Integer year);
    @Query("select distinct year(i.invoiceDate) from Invoice i where i.customerId = ?1")
    List<Integer> findAllYearInvoicesByCustomerId(Long id);
    @Modifying
    @Query("update Invoice i set i.invoiceDate=?2 where i.id = ?1")
    void updateInvoiceDate(Long id, Date date);



}
