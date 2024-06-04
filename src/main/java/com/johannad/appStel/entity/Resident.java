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


    @JsonBackReference
    @ManyToOne
    @JoinColumn(name= "fkid_user")
    private User user;
}
