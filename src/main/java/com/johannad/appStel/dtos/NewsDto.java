package com.johannad.appStel.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NewsDto {
    private int id;
    private String remNovedades;
    private String tipoNovedad;
    private String asuntoNovedades ;
    private String descNovedades;
    private Date fecNovedades;
    private String resNovedades;
    private String estNovedades;

    private RoleDto role;
}
