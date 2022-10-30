package org.ms.payementprojetservice.entities;

import lombok.*;
import org.ms.payementprojetservice.entities.Invoce.Invoice;
import org.ms.payementprojetservice.entities.customer.Customer;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="methode")
    private String payementMethod;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="transaction_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date transactionDate;
    @OneToOne(fetch = FetchType.EAGER)
    private Invoice invoice;
    @ManyToOne(fetch = FetchType.EAGER)
    private Customer customer;
}
