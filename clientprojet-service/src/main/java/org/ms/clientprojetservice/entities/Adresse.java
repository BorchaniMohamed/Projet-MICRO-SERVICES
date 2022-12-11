package org.ms.clientprojetservice.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name="Adresse")
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="Gouvernorat")
    private String gouvernorat;
    @Column(name="Delegation")
    private String delegation;
    @Column(name="localite")
    private String localite;
    @Column(name="codepostale")
    private Long codepostale;

    @Override
    public String toString() {
        return "Adresse{" +
                "gouvernorat='" + gouvernorat + '\'' +
                ", delegation='" + delegation + '\'' +
                ", localite='" + localite + '\'' +
                ", codepostale=" + codepostale +
                '}';
    }
}
