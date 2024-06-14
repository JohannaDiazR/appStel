package com.johannad.appStel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "tbl_tarifa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rate  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "tipo_vehiculo", length = 7)
    private String tipoVehc;
    @Column(name = "tipo_persona", length = 11)
    private String tipoPer;
    @Column(name = "rhora_ini")
    private Time rhoraIni;
    @Column(name="rhora_fin")
    private Time rhoraFin;
    @Column(name = "tarifa")
    private int tarifa;

    @JsonBackReference
    @OneToOne(mappedBy = "rate", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Parking parking;


}
