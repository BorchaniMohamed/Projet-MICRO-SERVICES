package org.ms.factureprojetservice.repository;

import org.ms.factureprojetservice.entities.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

//@RepositoryRestController
@RepositoryRestController
public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Long> {

    @Query("select count (i) from InvoiceLine i where i.stockItemId = ?1")
    Integer findInvoiceLineByStockItemId(Long id);
}
