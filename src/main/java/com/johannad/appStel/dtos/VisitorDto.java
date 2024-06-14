package com.johannad.appStel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitorDto {
    private int id;
    private String nomVisitante;
    private int cedula;
    private String nomResidente;
    private String carVisitante;
    private String ingrVisitante;
    private Date fecVisitante;

    @JsonIgnoreProperties({"role"})
    private WorkerDto worker;
    @JsonIgnoreProperties({"resident"})
    private ParkingDto parking;
    private PropertyDto property;
    //private UserDto user;


}
