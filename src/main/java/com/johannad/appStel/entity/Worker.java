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
@Table(name = "tbl_trabajador")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Worker  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    int id;
    @Column(name ="tpcoTrabajador", length = 40)
    String tpcoTrabajador; //Tipo de contrato indefinido/fijo/prestacion servicios
    @Column(name = "cargTrabajador", length = 30)
    String cargTrabajador; //Administrador, Todero, Vigilante
    @Column(name = "empTrabajador", length = 30)
    String empTrabajador; //Nombre de la empresa

    @JsonBackReference
    @OneToMany (mappedBy = "worker", fetch = FetchType.LAZY)
    private List<Correspondence> correspondenceList;

    @JsonBackReference
    @OneToMany (mappedBy = "worker", fetch = FetchType.LAZY)
    private List<Visitor> visitorList;

    @JsonBackReference
    @OneToMany (mappedBy = "worker", fetch = FetchType.LAZY)
    private List<Fine> fineList;

    @JsonBackReference
    @OneToMany (mappedBy = "worker", fetch = FetchType.LAZY)
    private List<WalletStatus> walletStatusList;

    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_rol")
    private Role role;

   @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_user")
    private User user;


}
