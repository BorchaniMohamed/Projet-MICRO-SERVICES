package org.ms.produitprojetservice.repository;

import org.ms.produitprojetservice.entities.StockItemCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;
@RestController
public interface StockItemCategoryRepository extends JpaRepository<StockItemCategory, Long> {
}
