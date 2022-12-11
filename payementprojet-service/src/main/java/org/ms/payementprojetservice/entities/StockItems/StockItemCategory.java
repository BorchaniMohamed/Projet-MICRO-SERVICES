package org.ms.payementprojetservice.entities.StockItems;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockItemCategory {

    private Long id;
    private String stockItemCategoryName;

}
