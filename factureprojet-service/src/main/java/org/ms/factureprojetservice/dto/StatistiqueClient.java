package org.ms.factureprojetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.ms.factureprojetservice.entities.Invoice;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
public class StatistiqueClient {
    private String customername;
    private Long cutomerid;
    //private Integer year;
    private Double ca;
    private Double reste;
    private List<Invoice> invoicespayed;
    private List<Invoice> invoicesnotpayed;
    //private Long rang;
    private Map<Long, Long> stockItems;

}
