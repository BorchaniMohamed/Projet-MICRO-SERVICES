package org.ms.factureprojetservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CAparAnnee {
    private Long cutomerids;
    private Double ca;
    private Integer year;

    public Long getCutomerids() {
        return cutomerids;
    }

    public void setCutomerids(Long cutomerids) {
        this.cutomerids = cutomerids;
    }

    public Double getCa() {
        return ca;
    }

    public void setCa(Double ca) {
        this.ca = ca;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
