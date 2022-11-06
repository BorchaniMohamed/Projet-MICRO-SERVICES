package org.ms.payementprojetservice.entities.Invoce;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ms.payementprojetservice.entities.StockItems.StockItem;


import javax.persistence.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class InvoiceLine {

    private Long id;


    private Invoice invoice;


    private StockItem stockItem;
    private Long stockItemId;


    private Integer quantity;
}
