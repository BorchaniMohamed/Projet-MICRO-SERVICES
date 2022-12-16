package org.ms.clientprojetservice.repository;

import org.ms.clientprojetservice.entities.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface AdresseRepository extends JpaRepository<Adresse,Long> {

}
