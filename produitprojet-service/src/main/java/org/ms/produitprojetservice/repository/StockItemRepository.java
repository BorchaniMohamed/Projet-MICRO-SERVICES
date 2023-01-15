package org.ms.produitprojetservice.repository;


import org.ms.produitprojetservice.entities.StockItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import java.util.Date;
import java.util.List;

@RepositoryRestController
public interface StockItemRepository extends JpaRepository<StockItem,Long> {
    List<StockItem> findStockItemsByAccountOpenedDate(Date date);

    @Query("select count (i)  from StockItem i where i.quantity=0 ")
    Integer produitrepture();

    @Query("select i  from StockItem i where i.quantity=0 ")
    List<StockItem> produitrepturestock();


}
