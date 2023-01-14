package org.ms.factureprojetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.ms.factureprojetservice.model.stockItem.StockItem;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RangProduit {
    private StockItem stockItem;
    private Integer year;
    private Integer qteVendue;
    private Double prixTotal;
}
