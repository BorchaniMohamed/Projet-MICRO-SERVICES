package org.ms.produitprojetservice.entities;

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
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name")
    private String nomfournissuer;
    @Column(name="dateopen")
    @Temporal(TemporalType.DATE)
    private Date accountOpenedDate;
    @Column(name="phone")
    private Long telephone;
    @Column(name="mail")
    private String email;
}
