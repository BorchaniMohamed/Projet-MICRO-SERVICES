package org.ms.clientprojetservice.repository;

import org.ms.clientprojetservice.entities.CustomerCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface CustomerCategoryRepository extends JpaRepository<CustomerCategory,Long> {

}
