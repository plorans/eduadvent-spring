package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Grupo;
import java.util.List;


@Repository
public interface GrupoDao extends JpaRepository<Grupo,Long>{
    
    Boolean existsByEscuela_EscuelaIdAndNivel_Id(String escuelaId, Long nivelId);

    
}
