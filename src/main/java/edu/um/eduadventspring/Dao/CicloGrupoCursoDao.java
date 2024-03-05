package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.um.eduadventspring.Model.CicloGrupoCurso;
import edu.um.eduadventspring.Model.CicloGrupoCursoId;
import java.util.List;


public interface CicloGrupoCursoDao extends JpaRepository<CicloGrupoCurso, CicloGrupoCursoId>{
    
    List<CicloGrupoCurso> findByEmpleadoId(String empleadoId);

    boolean existsByEmpleadoId(String empleadoId);
}
