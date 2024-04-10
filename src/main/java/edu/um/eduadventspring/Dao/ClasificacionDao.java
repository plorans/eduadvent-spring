package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Clasificacion;

import java.util.ArrayList;


@Repository
public interface ClasificacionDao extends JpaRepository<Clasificacion, Long> {

    ArrayList<Clasificacion> findByEscuela_EscuelaId(String escuelaId);

    @Query(value = "SELECT COALESCE(MAX(CLASFIN_ID)+1,'1') AS MAXIMO FROM CAT_CLASFIN WHERE ESCUELA_ID = :escuelaId ", nativeQuery = true)
    Integer maximoReg(String escuelaId);

    @Query(value = "DELETE FROM CAT_CLASFIN" +
            " WHERE ESCUELA_ID = :escuelaId AND CLASFIN_ID = :clasfinId", nativeQuery = true)
    Boolean deleteReg(String escuelaId, Integer clasfinId);

    @Query(value = "SELECT * FROM CAT_CLASFIN WHERE ESCUELA_ID = :escuelaId AND CLASFIN_ID = :clasfinId ", nativeQuery = true)
    Boolean existeReg(String escuelaId, Integer clasfinId);

    boolean existsByEscuela_EscuelaIdAndClasfinId(String escuelaId, Integer clasfinId);

    Clasificacion findByEscuela_EscuelaIdAndClasfinId(String escuelaId, Integer clasfinId);

}