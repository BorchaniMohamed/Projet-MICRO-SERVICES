package org.ms.clientprojetservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @Column(name="delivreyadress")
    private String deliveryAddress;
    @Column(name="dateopen")
    @Temporal(TemporalType.DATE)
    private Date accountOpenedDate;
    @Column(name="datebirth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirith;
    @Column(name="phone")
    private String phoneNumber;
    private String city;
    @Column(name="mail")
    private String customerEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne(fetch = FetchType.EAGER)
    private CustomerCategory customerCategory;

}
