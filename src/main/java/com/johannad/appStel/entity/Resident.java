package com.johannad.appStel.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "tblResidente")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resident implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_residente", length = 35)
    private String nomResidente;

    @Column(name = "ced_residente", length = 11)
    private int cedResidente;

    @Column(name = "ema_residente", length = 40)
    private String emaResidente;

    @Column(name = "cel_residente", length = 11)
    private long celResidente;

    @Column(name = "num_integrantes")
    private int numIntegrantes;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn (name = "fkid_parqueadero")
    private Parking parking;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fkid_rol")
    private Role role;

    @JsonBackReference
    @OneToMany (mappedBy = "resident")
    private List<Property> propertyList;



}
