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
@Table(name = "cat_asociacion")
public class Asociacion implements BaseModel {
    
    @Id
    @Column(name = "asociacion_id", length = 3)   
    private Long id;

    @Column(name = "asociacion_nombre", length = 70)
    private String nombre;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "union_id", nullable = false)
    private Union union;

    @Transient
    private String unionTmp;

    @Column(name = "fondo_id", length = 10)
    private String fondoId;

    @Column(name = "asociacion_corto", length = 30)
    private String nCorto;

}
