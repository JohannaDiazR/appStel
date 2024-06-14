package com.johannad.appStel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CorrespondenceDto {
    private int id;
    private String tipoCorrespondencia;
    private Date frecCorrespondencia;
    private String estCorrespondencia;
    private Date fentrCorrespondencia;
    @JsonIgnoreProperties({"role"})
    private WorkerDto worker;
    private PropertyDto property;

}
