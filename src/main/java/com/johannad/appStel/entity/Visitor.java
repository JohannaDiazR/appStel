package com.johannad.appStel.entity;
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
    private String nomVisitante; // Nombre del visitante

    @Column(name = "ced_visitante", length = 11)
    private int cedVisitante; // Cedula del visitante

    @Column(name = "nom_residente", length = 35)
    private String nomResidente; // Nombre del residente

    @Column(name = "car_visitante")
    private boolean carVisitante; // Carro del visitante

    @Column(name = "ingr_visitante")
    private boolean ingrVisitante; // Ingreso del visitante

    @Column(name = "fec_visitante")
    private Date fecVisitante; // Fecha ingreso del visitante

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fkid_trabajador")
    private Worker worker;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn (name = "fkid_parqueadero")
    private Parking parking;

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fkid_inmueble")
    private Property property;

}
