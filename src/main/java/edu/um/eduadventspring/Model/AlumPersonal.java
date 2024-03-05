package edu.um.eduadventspring.Model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "alum_personal")
public class AlumPersonal implements BaseModel{
    @Id
    private Long id;

    @Column(name = "codigo_id", length =  8)
    private String codigoId;

    @Column(name = "escuela_id", length = 3)
	private String escuelaId;

    @Column(name = "nombre", length = 40)
	private String nombre;

    @Column(name = "apaterno", length = 40)
	private String apaterno;

    @Column(name = "amaterno", length = 40)
	private String amaterno;

    @Column(name = "gender", length = 1)
	private Character genero;

    @Column(name = "curp", length = 19)
	private String curp;

    @Column(name = "f_nacimiento")
	private Date fNacimiento;

    @Column(name = "pais_id", length = 3)
	private Integer paisId;

    @Column(name = "estado_id", length = 3)
	private Integer estadoId;

    @Column(name = "ciudad_id", length = 3)
	private Integer ciudadId;

    @Column(name = "email", length = 50)
	private String email;

    @Column(name = "colonia", length = 50)
	private String colonia;

    @Column(name = "direccion", length = 50)
	private String direccion;

    @Column(name = "telefono", length = 60)
	private String telefono;

    @Column(name = "cotejado", length =  1)
	private Character cotejado;

    @Column(name = "nivel_id", length = 2)
	private Integer nivelId;

    @Column(name = "grado", length = 2)
	private Integer grado;

    @Column(name = "estado", length = 1)
	private Character estado;

    @Column(name = "grupo", length = 1)
	private Character grupo;

    @Column(name = "acta", length = 20)
	private String acta;

    @Column(name = "crip", length = 20)
	private String crip;

    @Column(name = "religion", length =  2)
	private Integer religion;

    @Column(name = "tranporte", length = 1)
	private Character transporte;

    @Column(name = "celular", length = 30)
	private String celular;

    @Column(name = "tutor", length = 50)
	private String tutor;

    @Column(name = "clasfin_id", length = 2)
	private Integer clasfinId;

    @Column(name = "matricula", length = 10)
	private Character matricula;

    @Column(name = "discapacidad", length = 1)
	private Character discapacidad;

    @Column(name = "enfermedad", length = 50)
	private String enfermedad;

    @Column(name = "correo", length = 50)
	private String correo;

    @Column(name = "iglesia", length = 70)
	private String iglesia;

    @Column(name = "tipo_sangre", length = 5)
	private String tipoSangre;

    @Column(name = "tutro_cedula", length = 20)
	private String tutorCedula;

    @Column(name = "barrio_id", length = 3)
	private Integer barrioId;

    @Column(name = "url_page")
    private String urlPage;

    @Column(name = "url_pago")
	private String urlPago;
}
