package com.johannad.appStel.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "tblParqueadero")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parking implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "tipo_parqueadero", length = 30)
    private String tipoParqueadero;

    @Column(name = "estado_parqueadero", length = 30)
    private String estadoParqueadero;

    @Column(name = "fec_parqueadero")
    private Date fecParqueadero;

    @Column(name = "dvte_parqueadero", length = 45)
    private String dvteParqueadero;

    @Column(name = "cup_parqueadero", length = 2)
    private int cupParqueadero;

    @Column(name = "hora_salida")
    private Date horaSalida;

    @Column(name = "costo_parqueadero", length = 5)
    private int costParqueadero;

    @JsonBackReference
    @OneToMany (mappedBy = "parking", fetch = FetchType.LAZY)
    private List<Resident> residentList;

    @JsonBackReference
    @OneToMany (mappedBy = "parking", fetch = FetchType.LAZY)
    private List<Visitor> visitorList;


}
