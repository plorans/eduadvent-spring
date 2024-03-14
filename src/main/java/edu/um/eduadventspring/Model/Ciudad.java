package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_ciudad")
public class Ciudad implements BaseModel{

    @Id
    private Long id;
    
    @Column(name = "pais_id", length = 3)
    private Long paisId;

    @Column(name = "estado_id", length = 3)
    private Long estadoId;

    @Column(name = "ciudad_id", length = 3)
    private Long ciudadId;

    @Column(name = "ciudad_nombre", length = 50)
    private String nombre;
}
