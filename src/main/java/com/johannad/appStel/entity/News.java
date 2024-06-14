package com.johannad.appStel.entity;
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
@Table(name = "tblNovedades")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class News implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "rem_novedades", length = 30)
    private String remNovedades;

    @Column(name = "tipo_novedad", length = 45)
    private String tipoNovedad;

    @Column(name = "asunto_novedades", length = 65)
    private String asuntoNovedades;

    @Column(name = "desc_novedades", length = 65)
    private String descNovedades;

    @Column(name = "fec_novedades")
    private Date fecNovedades;

    @Column(name = "res_novedades", length = 30)
    private String resNovedades;

    @Column(name = "est_novedades", length = 25)
    private String estNovedades;

    @JsonManagedReference
   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fkid_role")
    private Role role;

}
