package org.ms.factureprojetservice.model.customer;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Adresse {
    private Long id;
    private String gouvernorat;
    private String delegation;
    private String localite;
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
