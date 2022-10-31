package org.ms.clientprojetservice.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="customercategory")
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String customerCategoryName;

    @OneToMany(mappedBy = "customerCategory" ,fetch = FetchType.LAZY)
    private List<Customer> customerList = new ArrayList<>();

}
