package org.ms.factureprojetservice.entities;

import lombok.*;
import org.ms.factureprojetservice.entities.customer.Customer;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="invoice_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date invoiceDate;
    @Column(name="states")
    private String states;//TODO: ajouter states dans facture
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
    @OneToMany(fetch = FetchType.LAZY)
    private List<InvoiceLine> invoiceLines = new ArrayList<>();
}
