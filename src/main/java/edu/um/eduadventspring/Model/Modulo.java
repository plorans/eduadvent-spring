package edu.um.eduadventspring.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "modulo")
public class Modulo implements BaseModel{
    @Id
    private Long id;

    @Column(name = "modulo_id", length = 3)
    private String moduloId;

    @Column(name = "nombre_modulo", length = 30)
    private String nombreModulo;

    @Column(name = "url", length = 100)
    private String url;

    @Column(name = "rango", length = 3)
    private Integer rango;

    @Column(name = "menu_id", length = 2)
    private Integer menuId;
}
