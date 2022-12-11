package org.ms.clientprojetservice.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="customercategory")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class CustomerCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String customerCategoryName;


//    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
//    @OneToMany(mappedBy = "customerCategory",fetch = FetchType.LAZY,cascade = CascadeType.REMOVE)
//    private List<Customer> customers;



}
