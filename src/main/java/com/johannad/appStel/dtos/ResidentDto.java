package com.johannad.appStel.dtos;

import com.johannad.appStel.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResidentDto {
    private int id;
    private int numIntegrantes;

    private String userName;
    private int userCedula;

    private RoleDto role;
    private ParkingDto parking;
    private UserDto user;
}
