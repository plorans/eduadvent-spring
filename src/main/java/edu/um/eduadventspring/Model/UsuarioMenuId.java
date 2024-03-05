package edu.um.eduadventspring.Model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
@Table(name = "usuario_menu")
public class UsuarioMenuId implements BaseModel{

    @Column(name = "codigo_id", length = 8)
	private String codigoId;
	@Column(name = "opcion_id", length =  3)
	private Integer opcionId;

}
