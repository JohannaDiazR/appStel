package com.johannad.appStel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParkingDto {
    private int id;
    private String tipoParqueadero;
    private String estadoParqueadero;
    private Date fecParqueadero;
    private String dvteParqueadero;
    private int cupParqueadero;
    private Date horaSalida;

    private int costParqueadero;

    private RateDto rate;
}
