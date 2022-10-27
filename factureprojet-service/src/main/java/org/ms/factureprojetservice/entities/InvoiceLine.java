package org.ms.factureprojetservice.entities;

import lombok.*;
import org.ms.factureprojetservice.entities.stockItem.StockItem;

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
    @ManyToOne(fetch = FetchType.EAGER)
    private Invoice invoice;
    @ManyToOne(fetch = FetchType.EAGER)
    private StockItem stockItem;
    @Column(name="qte")
    private Integer quantity;

}
