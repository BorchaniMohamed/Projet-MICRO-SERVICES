package org.ms.clientprojetservice.entities;

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
    private String city;
    private String customerEmail;
    @ManyToOne(fetch = FetchType.EAGER)
    CustomerCategory customerCategory;

}
