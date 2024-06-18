package com.johannad.appStel.entity;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.jdbc.Work;

//import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "tbl_visitantes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Visitor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nom_visitante", length = 35)
    private String nomVisitante;
    @Column (name = "tipo-Documento", length = 40)
    private String tipoDoc;
    @Column(name = "cedula", length = 10)
    private int cedula;
    @Column(name = "nom_residente", length = 35)
    private String nomResidente; // Nombre del residente

    @Column(name = "car_visitante", length = 2)
    private String carVisitante; // Carro del visitante

    @Column(name = "ingr_visitante", length = 2)
    private String ingrVisitante; // Ingreso del visitante

    @Column(name = "fec_visitante")
    private Date fecVisitante; // Fecha ingreso del visitante

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_trabajador")
    private Worker worker;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "fkid_parqueadero")
    private Parking parking;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_inmueble")
    private Property property;

    /*@JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name= "fkid_user")
    private User user;*/
}
