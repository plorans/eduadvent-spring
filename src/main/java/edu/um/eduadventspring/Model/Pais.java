package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_pais")
public class Pais implements BaseModel{

    @Id
    @Column(name = "pais_id", length = 3)
    private Long id;

    @Column(name = "pais_nombre", length =40)
	private String nombre;
    
}
