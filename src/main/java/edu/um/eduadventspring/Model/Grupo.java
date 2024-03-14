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
@Table(name = "cat_grupo")
public class Grupo {

    public Grupo(){
        this.nombre = "-";
        this.escuelaId = "1";
    }
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_grupo_folio_seq")
    @SequenceGenerator(name = "cat_grupo_folio_seq", sequenceName = "cat_grupo_folio_seq", allocationSize = 1)
    private Long folio;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;

    @Transient
    private Long nivelId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "grado", referencedColumnName = "id", nullable = false)
    private Grado grado;

    @Transient
    private Long gradoId;

    @Column(name = "grupo", length = 1, nullable = false)
    private char grupoLetra;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "escuela_id", referencedColumnName = "escuela_id", nullable = false)
    private Escuela escuela;

    @Transient
    private String escuelaId;

    @Column(length = 1)
    private String turno;

    @Column(name = "grupo_nombre",length = 30)
    private String nombre;


}
