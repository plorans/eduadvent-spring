package edu.um.eduadventspring.Model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "usuario_menu")
public class UsuarioMenu implements BaseModel{
    
    @EmbeddedId
    private UsuarioMenuId id;

    



}
