package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_escuela")
public class Escuela implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_escuela_id_seq")
    @SequenceGenerator(name = "cat_escuela_id_seq", sequenceName = "cat_escuela_id_seq", allocationSize = 1)
    private long id;

    @Column(name = "escuela_id", unique = true, nullable = false, length = 3)
    private String escuelaId;

    @Column(name = "escuela_nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "nombre_corto", nullable = false, length = 25)
    private String nombreCorto;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "pais_id", referencedColumnName = "pais_id", nullable = false)
    private Pais paisId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "estado_id", referencedColumnName = "id", nullable = false)
    private Estado estadoId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ciudad_id", referencedColumnName = "id", nullable = false)
    private Ciudad ciudadId;

    @Column(length = 40)
    private String colonia;

    @Column(length = 100)
    private String direccion;

    @Column(length = 30)
    private String telefono;

    @Column(length = 30)
    private String fax;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "asociacion_id", referencedColumnName = "asociacion_id", nullable = false)
    private Asociacion asociacionId;

    @Column(length = 15)
    private String logo;

    @Column(length = 1)
    private Character estado;

    @Column(length = 15, columnDefinition = "default 'firma.png'", nullable = false)
    private String firma;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "union_id", referencedColumnName = "union_id", nullable = false)
    private Union union;

    @Column(length = 10)
    private String distrito;

    @Column(length = 100)
    private String eslogan;

    @Column(length = 40)
    private String sector;

    @Column(length = 40)
    private String zona;

    @Column(length = 30)
    private String www;

    @Column(length = 30)
    private String registro;
}
