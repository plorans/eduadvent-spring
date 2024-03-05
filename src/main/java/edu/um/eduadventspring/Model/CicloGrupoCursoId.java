package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(name = "usuario_menu")
public class CicloGrupoCursoId implements BaseModel{

    @Column(name = "ciclo_grupo_id", length = 11)
    private String cicloGrupoId;

    @Column(name = "curso_id", length = 12)
    private String cursoId;
}
