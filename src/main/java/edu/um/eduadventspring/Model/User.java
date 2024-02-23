package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario")
public class User{
    @Id()
    private Long id;

    @Column(name = "codigo_id", length =  8, nullable = false)
    private String codigoId;

    @Column(name = "tipo_id", length = 2, nullable = false)
    private Integer tipoId;

    @Column(name = "cuenta")
    private String usuario;

    @Column(name = "clave")
    private String password;

    @Column(name = "administrador")
    private String administrador;

    @Column(name = "escuela", length = 1700)
    private String escuela;

    @Column(name = "plan", length = 100)
    private String plan;

    @Column(name = "cotejador")
    private Character cotejador;

    @Column(name = "contable")
    private Character contable;

    @Column(name = "nivel", length = 15)
    private String nivel;

    @Column(name = "super")
    private Character sup;

    @Column(name = "asociacion", length = 300 , nullable = false)
    private String asociacion;

    @Column(name = "division")
    private Character division;

    @Column(name = "idioma")
    private String idioma;
}
