package com.johannad.appStel.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
@Entity
@Table(name = "tbl_Rol")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nombre_Rol", length = 30)//Rol
    private String nombreRol;



    @JsonBackReference
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> userList;

    @JsonBackReference
    @OneToMany (mappedBy = "role", fetch = FetchType.LAZY)
    private List<Worker> workerList;

    @JsonBackReference
    @OneToMany (mappedBy = "role", fetch = FetchType.LAZY)
    private List<Resident> residentList;

    @JsonBackReference
    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<News> newsList;
}
