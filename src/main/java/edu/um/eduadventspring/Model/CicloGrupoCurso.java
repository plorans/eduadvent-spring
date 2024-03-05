package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "")
public class CicloGrupoCurso {
    
    @EmbeddedId
    private CicloGrupoCursoId id;

    @Column(name = "empleado_id", length = 8)
    private String empleadoId;

    @Column(name = "horario", length = 147)
    private String horario;

    @Column(name = "salon_id", length = 2)
    private Integer salonId;

    @Column(name = "estado")
    private Character estado;
}
