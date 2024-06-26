package com.johannad.appStel.dtos;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class WorkerDto {
    private int id;
    private String tpcoTrabajador;
    private String cargTrabajador;
    private String empTrabajador;

    private String userName;
    private int userCedula;

    private RoleDto role;
    private UserDto user;


}
