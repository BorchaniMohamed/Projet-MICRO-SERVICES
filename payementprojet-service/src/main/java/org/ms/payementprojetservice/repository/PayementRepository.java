package org.ms.payementprojetservice.repository;

import org.ms.payementprojetservice.entities.Invoce.Invoice;
import org.ms.payementprojetservice.entities.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.List;

@RepositoryRestController
public interface PayementRepository extends JpaRepository<Transaction,Long> {
    @Query("select sum(t.amounttransaction) from Transaction t where t.invoice_id = ?1")
    Double findTransactionsByInvoice_id(Long id);




}
