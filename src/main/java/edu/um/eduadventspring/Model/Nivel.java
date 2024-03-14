package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "cat_nivel")
public class Nivel {

    public Nivel(){
        this.inicio = 1L;
        this.fin = 6L;
        this.titulo = "Grado";
        this.notaminima = 5L;
    }

    @Id
    @Column(name = "nivel_id", length = 2, nullable = false)
    private Long id;

    @Column(name = "nivel_nombre", length = 30, nullable = false)
    private String nombre;

    @Column(name = "grado_ini", length = 2)
    private Long inicio;

    @Column(name = "grado_fin", length = 2)
    private Long fin;

    private char metodo;

    @Column(length = 20)
    private String titulo;

    @Column(length = 2)
    private Long notaminima;
    
    @Column(name = "nombre_corto", length = 20)
    private String nombreCorto;
    
    

}
