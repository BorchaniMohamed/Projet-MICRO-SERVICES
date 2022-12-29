package org.ms.factureprojetservice.model.stockItem;


import lombok.*;

import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Fournisseur {
    private Long id;
    private String nomfournissuer;
    private Date accountOpenedDate;
    private Long telephone;
    private String email;
}
