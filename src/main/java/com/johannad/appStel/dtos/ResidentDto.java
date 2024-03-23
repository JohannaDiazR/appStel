package com.johannad.appStel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentDto {
    private int id;
    private String nomResidente;
    private int cedResidente;
    private String emaResidente;
    private long celResidente;
    private int numIntegrantes;

    private RoleDto role;
    private ParkingDto parking;
}
