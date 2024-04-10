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
@Table(name = "cat_clasfin")
public class Clasificacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "cat_clasfin_id_seq")
    @SequenceGenerator(name = "cat_clasfin_id_seq", sequenceName = "cat_clasfin_id_seq", allocationSize = 1)
    private Long id;

    @Column(name = "clasfin_id", length = 2)
    private Integer clasfinId;

    @Column(name = "clasfin_nombre", length = 30)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "escuela_id", referencedColumnName = "escuela_id", nullable = false)
    private Escuela escuela;

    @Column(name = "estado", length = 1)
    private Character estado;

    @Transient
    private String accion;
}
