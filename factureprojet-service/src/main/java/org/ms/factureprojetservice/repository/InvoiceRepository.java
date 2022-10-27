package org.ms.factureprojetservice.repository;

import org.ms.factureprojetservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
