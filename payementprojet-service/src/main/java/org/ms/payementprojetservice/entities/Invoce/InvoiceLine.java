package org.ms.payementprojetservice.entities.Invoce;

import lombok.*;
import org.ms.payementprojetservice.entities.stockItem.StockItem;

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
