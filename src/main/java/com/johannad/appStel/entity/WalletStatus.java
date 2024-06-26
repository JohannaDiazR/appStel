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
@Table(name = "tbl_estcartera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletStatus implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    @Column(name = "est_cartera", length = 30)
    String estcartera; //estado de cartera mora//paz y salvo
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fec_estcartera")
    Date fecestcartera;
    @Column(name = "noti_estcartera", length = 35)
    String notiestcartera; //Notificar al residente


    //Llaves foraneas
    //fkidInmueble
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_inmueble")
    private Property property;

    //fkidTrabajador
    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_trabajador")
    private Worker worker;
}
