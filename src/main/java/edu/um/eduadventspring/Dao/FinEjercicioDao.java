package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.um.eduadventspring.Model.FinEjercicio;

public interface FinEjercicioDao extends JpaRepository<FinEjercicio, Long> {

    @Query(value = "SELECT ID FROM FIN_EJERCICIO WHERE ESCUELA_ID = :escuelaId AND NOW() BETWEEN FECHA_INI AND FECHA_FIN", nativeQuery = true)
    Long getEjercicioActualDao(String escuelaId);
}
