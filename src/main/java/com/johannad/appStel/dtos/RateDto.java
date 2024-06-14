package com.johannad.appStel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RateDto {
    private int id;
    private String tipoVehc;
    private String tipoPer;
    private Time rhoraIni;
    private Time rhoraFin;
    private int tarifa;

    private ParkingDto parking;
}
