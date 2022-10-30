package org.ms.factureprojetservice.repository;

import org.ms.factureprojetservice.entities.InvoiceLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestController
@Repository
public interface InvoiceLineRepository extends JpaRepository<InvoiceLine, Long> {
}
