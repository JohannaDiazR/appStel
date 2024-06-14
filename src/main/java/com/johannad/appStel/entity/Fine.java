package com.johannad.appStel.entity;
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
@Table(name = "tbl_multa")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Fine implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    @Column(name = "tipo_multa", length = 30)
    String tipoMulta; //tipo multa razon de la multa
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_multa")
    Date fecMulta; //Fecha en la que se pone la multa
    @Column(name = "val_multa", nullable = false)
    int valMulta; //Valor a pagar la multa
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fpag_multa")
    Date fpagMulta;

    //Foraneas
    //fkidInmueble
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "fkid_inmueble")
    private Property property;
    //fkidTrabajador
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "fkid_trabajador")
    private Worker worker;


}
