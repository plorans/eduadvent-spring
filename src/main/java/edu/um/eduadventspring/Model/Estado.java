package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_estado")
public class Estado implements BaseModel {
    
    @Id
    private Long id;

    @Column(name = "pais_id", length = 3)
    private Long paisId;

    @Column(name = "estado_id", length = 3)
    private Long estadoId;

    @Column(name = "estado_nombre", length = 40)
    private String nombre;

    @Column(name = "clave")
    private Character clave;
}
