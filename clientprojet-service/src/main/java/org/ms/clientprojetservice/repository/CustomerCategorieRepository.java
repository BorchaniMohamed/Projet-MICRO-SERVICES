package org.ms.clientprojetservice.repository;

import org.ms.clientprojetservice.entities.CustomerCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;

@RepositoryRestController
public interface CustomerCategorieRepository extends JpaRepository<CustomerCategorie,Long> {

}
