package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_esquema")
public class Grado {

    public Grado(){
        this.gradoNombre = "GRADO";
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_esquema_id_seq")
    @SequenceGenerator(name = "cat_esquema_id_seq", sequenceName = "cat_esquema_id_seq", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "escuela_id", referencedColumnName = "escuela_id", nullable = false)
    private Escuela escuela;

    @Transient
    private String escuelaId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;

    @Transient
    private Long nivelId;

    @Column(name = "grado",length = 2)
    private Long gradoNum;

    @Column(name = "esquema_evaluacion", length = 1)
    private String evaluacion;

    @Column(name = "sub_nivel", length = 2)
    private Long subNivel;

    @Column(name = "grado_nombre", length = 50)
    private String gradoNombre;

    @Column(name = "semestre_nombre", length = 50)
    private String semestre;

}
