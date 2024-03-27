package com.johannad.appStel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FineDto {
    private int id;
    private String tipoMulta;
    private Date fecMulta;
    private int valMulta;
    private Date fpagMulta;
    @JsonIgnoreProperties({"resident"})
    private PropertyDto property;
    @JsonIgnoreProperties({"role"})
    private WorkerDto worker;
}
