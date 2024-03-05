package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "modulo_opcion")
public class ModuloOpcion implements BaseModel{
    
    @Id
    private Long id;

    @Column(name = "modulo_id", length = 3)
	private String moduloId;

	@Column(name = "opcion_id", length =  3)
	private Integer opcionId;

    @Column(name = "nombre_opcion", length = 40)
    private String nombreOpcion;

    @Column(name = "url", length = 100)
    private String url;

    @Column(name = "orden", length = 2)
    private Integer orden;

    @Column(name = "acceso")
    private Character acceso;

    @Column(name = "estado")
    private Character estado;
}
