package com.johannad.appStel.entity;
import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "tbl_Usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "usuario", length = 30)
    private String usuario;  // Nombre de usuario

    @Column(name = "contrasena", length = 15)
    private String contrasena; // Contraseña del usuario
    //Normalización
    @Column(name = "nombre", length = 35)
    private String nombre;

    @Column(name = "cedula")
    private int cedula;

    @Column(name = "celular", length = 11)
    private long celular;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fkid_rol")
    private Role role;

    @JsonManagedReference
    @OneToMany(mappedBy = "user")
    private List<Resident> resident;

    @JsonManagedReference
    @OneToMany (mappedBy = "user")
    private List<Worker> worker;

    @JsonManagedReference
    @OneToMany (mappedBy = "user")
    private List<Visitor> visitor;
}


