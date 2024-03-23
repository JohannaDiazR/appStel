package com.johannad.appStel.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "cup_parqueadero", length = 11)
    private int cupParqueadero;

    @Column(name = "hora_salida")
    private Date horaSalida;

    @Column(name = "tar_parqueadero", length = 11)
    private int tarParqueadero;

    @JsonBackReference
    @OneToMany (mappedBy = "parking")
    private List<Resident> residentList;

    @JsonBackReference
    @OneToMany (mappedBy = "parking")
    private List<Visitor> visitorList;

}
