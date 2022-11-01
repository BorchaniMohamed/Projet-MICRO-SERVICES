package org.ms.produitprojetservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class StockItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String stockItemName;
    private String brand;
    private String carateristique;

    @Column(name="taxerate")
    private Double taxrate;

    @Column(name="prix")
    private Double price;

    @Column(name="qte")
    private Integer quantity;
    @Temporal(TemporalType.DATE)
    private Date validTo;
    @Temporal(TemporalType.DATE)
    private Date ValidForm;
    private String photoPath;
    @ManyToOne(fetch = FetchType.EAGER)
    StockItemCategory  stockTtemCategorie;
}
