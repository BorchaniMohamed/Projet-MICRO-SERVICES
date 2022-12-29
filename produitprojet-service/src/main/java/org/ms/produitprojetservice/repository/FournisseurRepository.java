package org.ms.produitprojetservice.repository;

import org.ms.produitprojetservice.entities.Fournisseur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Date;
import java.util.List;

@RepositoryRestController
public interface FournisseurRepository extends JpaRepository<Fournisseur,Long> {
    List<Fournisseur> findFournisseurByAccountOpenedDate(Date date);
}
