package com.johannad.appStel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
//@JsonIgnoreProperties({"role"})
public class UserDto {
    private int id;
    private String usuario;
    private String contrasena;
    private String nombre;
    private String tipoDoc;
    private int cedula;
    private long celular;

    private RoleDto role;
    private ResidentDto resident;
    private WorkerDto worker;
    //private VisitorDto visitor;

}
