package org.ms.payementprojetservice.entities.customer;

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
    private String deliveryAddress;

    private Date accountOpenedDate;

    private Date dateOfBirith;
    private String phoneNumber;

    private String city;
    private String customerEmail;

    CustomerCategory customerCategory;

}
