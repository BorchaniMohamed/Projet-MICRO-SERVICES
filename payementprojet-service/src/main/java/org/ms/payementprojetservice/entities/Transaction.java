package org.ms.payementprojetservice.entities;

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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="methode")
    private String payementMethod;
    @Temporal(TemporalType.TIMESTAMP)
    private Date transactionDate;
    @Column(name="amounttransaction")
    private Double amounttransaction;
    private Long invoice_id;
    private String devise;
    private Double montant_en_devise;
}
