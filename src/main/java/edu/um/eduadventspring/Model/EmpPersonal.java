package edu.um.eduadventspring.Model;

import java.sql.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "emp_personal")
public class EmpPersonal implements BaseModel{
    
    @Id
    private Long id;

    @Column(name = "codigo_id", length =  8)
    private String codigoId;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apaterno")
    private String apaterno;

    @Column(name = "amaterno")
    private String amaterno;

    @Column(name = "f_nacimiento")
    private Date fNacimiento;

    @Column(name = "genero")
    private Character genero;

    @Column(name = "estado")
    private Character estado;

    @Column(name = "escuela_id", length = 3)
    private String escuelaId;

    @Column(name = "pais_id", length = 3)
    private String paisId;

    @Column(name = "estado_id", length = 3)
    private String estadoId;

    @Column(name = "ciudad_id", length = 3)
    private String ciudadId;

    @Column(name = "email")
    private String email;

    @Column(name = "colonia")
    private String colonia;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "estado_civil")
    private Character estadoCivil;

    @Column(name = "tipo_id")
    private Integer tipoId;

    @Column(name = "ocupacion")
    private String ocupacion;

    @Column(name = "rfc")
    private String rfc;

    @Column(name = "ssocial")
    private String ssocial;

    @Column(name = "publicar")
    private Character publicar;

    @Column(name = "iglesia")
    private String iglesia;

    @Column(name = "tipo_sangre")
    private String tipoSangre;

    

}
