package org.ms.payementprojetservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="methode")
    private String payementMethod;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="transaction_date",columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date transactionDate;

    @Column(name="amounttransaction")
    private Double amounttransaction;

    @Transient
    private Invoice invoice;
    private Long invoice_id;

//    @Transient
//    private Customer customer;
//    private Long costumer_id;
}
