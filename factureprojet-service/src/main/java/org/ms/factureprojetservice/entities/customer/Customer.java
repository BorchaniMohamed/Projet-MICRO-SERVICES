package org.ms.factureprojetservice.entities.customer;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String customerName;
    private String deliveryAddress;
    @Temporal(TemporalType.DATE)
    private Date accountOpenedDate;
    @Temporal(TemporalType.DATE)
    private Date dateOfBirith;
    private String phoneNumber;
    @Column(name="city")
    private String city;
    private String customerEmail;
    @ManyToOne(fetch = FetchType.EAGER)
    CustomerCategory customerCategory;

}
