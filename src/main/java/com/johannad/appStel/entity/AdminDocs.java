package com.johannad.appStel.entity;
import com.fasterxml.jackson.annotation.JsonAlias;
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
@Table(name = "tblDocsadmin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminDocs implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "class_docsadmin", length = 30)
    private String classDocsAdmin;

    @Column(name = "peti_docsadmin", length = 30)
    private String petiDocsAdmin;
    @JsonManagedReference
    @ManyToOne
    @JoinColumn(name = "fkid_trabajador")
    private Worker worker;

}
