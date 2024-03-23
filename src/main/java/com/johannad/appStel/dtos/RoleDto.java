package com.johannad.appStel.dtos;

import com.johannad.appStel.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {
    private int id;
    private String nombreRol;
//private Role role;

}
