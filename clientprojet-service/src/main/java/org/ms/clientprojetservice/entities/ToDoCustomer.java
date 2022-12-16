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
@Table(name="todocustomer")
public class ToDoCustomer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="actiontodo")
    private String actionToDo;
    @Column(name="dateofaction")
    @Temporal(TemporalType.DATE)
    private Date dateOfAction;
//    @ManyToOne
//    private Customer customer;
//
//    @Column(name="customerid")
//    private Long cutomer_ID;
}
