package org.ms.payementprojetservice.entities.StockItems;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class StockItem {

    private Long id;

    private String stockItemName;
    private String brand;
    private String carateristique;


    private Double taxrate;


    private Double price;


    private Integer quantity;

    private Date validTo;

    private Date ValidForm;
    private String photoPath;

    StockItemCategory  stockTtemCategorie;
}
