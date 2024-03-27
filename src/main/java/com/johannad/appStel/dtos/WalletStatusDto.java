package com.johannad.appStel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletStatusDto {
    private int id;
    private String estcartera;
    private String taccestcartera;
    private String notiestcartera;

    @JsonIgnoreProperties({"resident"})
    private PropertyDto property;
    @JsonIgnoreProperties({"role"})
    private WorkerDto worker;

}
