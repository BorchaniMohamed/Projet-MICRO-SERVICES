package org.ms.factureprojetservice.model.transaction;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Transaction {

    private Long id;

    private String payementMethod;

    private Date transactionDate;

    private Double amount;


    //private Invoice invoice;
    private Long invoice_id;


    //private Customer customer;
    private Long costumer_id;
}
