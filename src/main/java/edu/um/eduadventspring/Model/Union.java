package edu.um.eduadventspring.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "cat_union")
public class Union {

    @Id
    @Column(name = "union_id", length = 2)
    private Long id;    

    @Column(name = "union_nombre", length = 50)
    private String nombre;

    @Column(name = "credencial", length = 20)
    private String credencial;

    @Column(name = "letra", length = 1)
    private String letra;

    @Column(name = "org_id", length = 10)
    private String orgId;
}
