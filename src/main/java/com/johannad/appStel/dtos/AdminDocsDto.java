package com.johannad.appStel.dtos;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDocsDto {
    private int id;
    private String classDocsAdmin;
    private String petiDocsAdmin;
    @JsonIgnoreProperties({"role"})
    private WorkerDto worker;

}
