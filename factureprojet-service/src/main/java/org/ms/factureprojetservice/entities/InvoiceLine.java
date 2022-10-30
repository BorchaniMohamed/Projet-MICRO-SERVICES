package org.ms.factureprojetservice.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.ms.factureprojetservice.model.stockItem.StockItem;

import javax.persistence.*;

@Entity
@Table(name="invoice_line")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class InvoiceLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    private Invoice invoice;

    @Transient
    private StockItem stockItem;
    private Long stockItemId;

    @Column(name="qte")
    private Integer quantity;



}
