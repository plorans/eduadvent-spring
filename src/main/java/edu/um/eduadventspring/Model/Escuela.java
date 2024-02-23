package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_escuela")
public class Escuela {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_escuela_id_seq")
    @SequenceGenerator(name = "cat_escuela_id_seq", sequenceName = "cat_escuela_id_seq",  allocationSize = 1)
    private long id;

    @Column(name = "escuela_id", unique = true, nullable = false, length = 3)
    private String escuelaId;

    @Column(name = "escuela_nombre", nullable = false, length = 70)
    private String nombre;

    @Column(name = "nombre_corto", nullable = false ,length = 25)
    private String nombreCorto;

    @Column(length = 40)
    private String colonia;

    @Column(length = 100)
    private String direccion;

    @Column(length = 30)
    private String telefono;

    @Column(length = 30)
    private String fax;

    @Column(length = 15)
    private String logo;

    @Column(length = 1)
    private Character estado;

    @Column(length = 15, columnDefinition = "default 'firma.png'", nullable = false)
    private String firma;

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
