package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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

    @Column(name = "union_id", length = 2)
    private Integer unionId;

    @Column(name = "fondo_id", length = 10)
    private String fondoId;

    @Column(name = "asociacion_corto", length = 30)
    private String nCorto;

}
