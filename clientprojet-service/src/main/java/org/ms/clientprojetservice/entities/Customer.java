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
    @Column(name="dateopen")
    @Temporal(TemporalType.DATE)
    private Date accountOpenedDate;
    @Column(name="datebirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirith;
    @Column(name="phone")
    private String phoneNumber;
    @Column(name="mail")
    private String customerEmail;
    @ManyToOne
    private CustomerCategory customerCategory;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private Adresse adresse;
    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.REMOVE)
    private ToDoCustomer todocustomer;


}
