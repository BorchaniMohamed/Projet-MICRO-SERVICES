package org.ms.factureprojetservice.repository;

import org.ms.factureprojetservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestController
@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}
