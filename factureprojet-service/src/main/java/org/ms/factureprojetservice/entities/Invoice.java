package org.ms.factureprojetservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.ms.factureprojetservice.model.customer.Customer;

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
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date invoiceDate;
    @Column(name="states")
    private String states;
    @Transient
    private Customer customer;
    private Long customerId;
    private Double amount;
    @OneToMany(mappedBy = "invoice" ,fetch = FetchType.EAGER, cascade= CascadeType.ALL)
    private List<InvoiceLine> invoiceLines = new ArrayList<>();


}
