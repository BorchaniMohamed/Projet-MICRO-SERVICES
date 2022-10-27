package org.ms.produitprojetservice.repository;


import org.ms.produitprojetservice.entities.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface StockItemRepository extends JpaRepository<StockItem,Long> {

}
