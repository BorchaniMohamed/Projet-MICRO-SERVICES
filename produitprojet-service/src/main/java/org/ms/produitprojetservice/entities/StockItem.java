package org.ms.produitprojetservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stockItemName;
    private String brand;
    private String carateristique;
    private double taxrate;
    private double unitprice;
    private int quantity;
    @Temporal(TemporalType.DATE)
    private Date validTo;
    @Temporal(TemporalType.DATE)
    private Date ValidForm;
    private String photoPath;
    @ManyToOne(fetch = FetchType.EAGER)
    StockItemCategory  stockTtemCategorie;
}
