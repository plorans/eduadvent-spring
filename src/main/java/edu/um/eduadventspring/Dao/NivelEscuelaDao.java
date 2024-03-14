package edu.um.eduadventspring.Dao;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.NivelEscuela;
import java.util.List;



@Repository
public interface NivelEscuelaDao extends JpaRepository<NivelEscuela,Long>{

    List<NivelEscuela> findByEscuela_EscuelaId(String escuelaId, Sort sort);
    
}
