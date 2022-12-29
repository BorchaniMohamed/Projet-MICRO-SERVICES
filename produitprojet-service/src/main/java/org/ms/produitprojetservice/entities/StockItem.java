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
    @Column(name="prix")
    private Double price;
    @Column(name="qte")
    private Integer quantity;
    @Temporal(TemporalType.DATE)
    private Date validTo;
    @Temporal(TemporalType.DATE)
    private Date ValidForm;
    @Column(name="dateopen")
    @Temporal(TemporalType.DATE)
    private Date accountOpenedDate;
    @ManyToOne(fetch = FetchType.EAGER)
    StockItemCategory  categorie;
    @ManyToOne(fetch = FetchType.EAGER)
    private Fournisseur fournisseur;
}
