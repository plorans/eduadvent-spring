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
@Table(name = "cat_nivel_escuela")
public class NivelEscuela {

    public NivelEscuela() {
        this.notaminima = 5L;
        this.titulo = "-";
        this.funcionId = "-";
        this.registro = "-";
        this.existeNivel = false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_nivel_escuela_id_seq")
    @SequenceGenerator(name = "cat_nivel_escuela_id_seq", sequenceName = "cat_nivel_escuela_id_seq", allocationSize = 1)
    private Long Id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "escuela_id", referencedColumnName = "escuela_id", nullable = false)
    private Escuela escuela;

    @Transient
    private String escuelaCodigo;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "nivel_id", nullable = false)
    private Nivel nivel;

    @Transient
    private Long nivelId;

    @Column(length = 2)
    private Long notaminima;

    @Column(name = "grado_ini", length = 2)
    private Long gradoIni;

    @Column(name = "grado_fin", length = 2)
    private Long gradoFin;

    @Column(name = "nivel_nombre", length = 40)
    private String nivelNombre;

    @Column(length = 20)
    private String titulo;

    @Column(length = 2)
    private Long peso;

    @Column(name = "funcion_id", length = 10, nullable = false)
    private String funcionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "director", referencedColumnName = "codigo_id", nullable = false)
    private EmpPersonal director;

    @Column(length = 30)
    private String registro;

    @Transient
    private Boolean existeNivel;
}
