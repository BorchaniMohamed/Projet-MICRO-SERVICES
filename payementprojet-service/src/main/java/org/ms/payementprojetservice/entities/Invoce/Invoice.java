package org.ms.payementprojetservice.entities.Invoce;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.ms.payementprojetservice.entities.customer.Customer;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Invoice {

    private Long id;
    private Date invoiceDate;
    private String states;
    private Customer customer;
    private Long customerId;
    private Double restetopayed;
    private Double amount;




}
