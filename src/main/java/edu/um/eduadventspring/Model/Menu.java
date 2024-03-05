package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "menu")
public class Menu implements BaseModel{
    
    @Id
    @Column(name = "menu_id")
    private long id;

    @Column(name = "menu_nombre")
    private String nombre;
}
