package org.ms.factureprojetservice.entities.stockItem;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "stock_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String stockItemName;
    private String brand;
    private String carateristique;
    private Double taxrate;
    @Column(name="prix")
    private Double unitPrice;
    @Column(name="qte")
    private Long quantity;
    @Temporal(TemporalType.DATE)
    private Date validTo;
    @Temporal(TemporalType.DATE)
    private Date ValidForm;
    private String photoPath;
    @ManyToOne(fetch = FetchType.EAGER)
    StockItemCategory stockTtemCategorie;
}
