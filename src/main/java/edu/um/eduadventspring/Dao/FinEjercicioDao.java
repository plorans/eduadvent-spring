package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.um.eduadventspring.Model.FinEjercicio;

import java.sql.Date;


public interface FinEjercicioDao extends JpaRepository<FinEjercicio,Long>{
    
    FinEjercicio findByEscuelaIdAndFechaIniLessThanEqualAndFechaFinGreaterThanEqual(String escuelaId, Date fechaIni, Date fechaFin);
}
