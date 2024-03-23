package com.johannad.appStel.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_correspondencia")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Correspondence  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    @Column(name = "tipo_correspondencia", length = 30)
    private String tipoCorrespondencia; //Tipo correspondencia paquete/carta/recibo
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "frec_correspodencia")
    private Date frecCorrespondencia; //Fecha en la que ingresa la correspondencia al conjunto
    @Column(name = "est_correspondencia", length = 20)
    private String estCorrespondencia; //Estado de correspondencia entregado/no entregado
    //@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fentr_correspondencia")
    private Date fentrCorrespondencia; //Fecha en la que se entrega la correspondencia

    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fkid_trabajador")
    private Worker worker;
    @JsonBackReference
    @ManyToMany(mappedBy = "correspondence", fetch = FetchType.LAZY)
    private List<Property> propertyList;


}
