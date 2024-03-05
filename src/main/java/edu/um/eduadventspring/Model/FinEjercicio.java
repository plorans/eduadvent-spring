package edu.um.eduadventspring.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "fin_ejercicio")
public class FinEjercicio implements BaseModel{
    
    @Id
    private Long id;

    @Column(name = "ejercicio_id", length = 8)
    private String ejercicioId;

    @Column(name = "escuela_id", length = 3)
    private String escuelaId;

    @Column(name = "year", length = 4)
    private Integer year;

    @Column(name = "fecha_ini")
    private Date fechaIni;

    @Column(name = "fecha_fin")
    private Date fechaFin;
}
