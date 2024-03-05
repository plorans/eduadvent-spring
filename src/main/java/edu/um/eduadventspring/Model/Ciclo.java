package edu.um.eduadventspring.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ciclo")
public class Ciclo implements BaseModel{
    
    @Id
    private Long id;

    @Column(name = "ciclo_id", length = 8)
    private String cicloId;

    @Column(name = "ciclo_nombre", length = 40)
    private String cicloNombre;

    @Column(name = "f_creada")
    private Date fCreada;

    @Column(name = "f_inicial")
    private Date fInicial;

    @Column(name = "f_final")
    private Date fFinal;

    @Column(name = "num_cursos", length = 3)
    private Integer numCursos;

    @Column(name = "estado")
    private Character estado;

    @Column(name = "escala", length = 3)
    private Integer escala;

    @Column(name = "modulos", length = 2)
    private Integer modulos;

    @Column(name = "editar_actividad", length = 2)
    private String editarActividad;

    @Column(name = "ciclo_escolar", length = 4)
    private String cicloEscolar;

    @Column(name = "decimales",length = 1)
    private Integer decimales;

    @Column(name = "redondeo", length = 1)
    private String redondeo;

    @Column(name = "nivel_eval", length = 1)
    private String nivelEval;

    @Column(name = "nivel_cademico_sistema", length = 2)
    private String nivelAcademicoSistema;
}
