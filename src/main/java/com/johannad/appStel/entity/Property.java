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
@Table(name = "tbl_Inmueble")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Property implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "and_inmueble")//anden donde se ubica el inmueble
    private int andInmueble;

    @Column(name = "num_inmueble")//numero del inmueble
    private int numInmueble;

    @JsonBackReference
    @OneToMany (mappedBy = "property", fetch = FetchType.LAZY)
    private  List<Fine> fineList;

    @JsonBackReference
    @OneToMany (mappedBy = "property", fetch = FetchType.LAZY)
    private List<WalletStatus> walletStatusList;

    @JsonBackReference
    @OneToMany (mappedBy = "property", fetch = FetchType.LAZY)
    private List<Visitor> visitorList;


    @JsonManagedReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_residente")
    private Resident resident;

    @JsonBackReference
    @OneToMany (mappedBy = "property",fetch = FetchType.LAZY)
    private  List<Correspondence> correspondenceList;



}
