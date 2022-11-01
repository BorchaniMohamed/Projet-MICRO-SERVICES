package org.ms.factureprojetservice.model.stockItem;

import lombok.*;

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

    private Long quantity;

    private Date validTo;

    private Date ValidForm;
    private String photoPath;

    StockItemCategory stockTtemCategorie;
}
