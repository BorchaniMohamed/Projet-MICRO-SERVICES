package org.ms.factureprojetservice.model.customer;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private Long id;
    private String customerName;
    private Date accountOpenedDate;
    private Date dateOfBirith;
    private String phoneNumber;
    private String customerEmail;
    CustomerCategory customerCategory;
    Adresse adresse;

}
