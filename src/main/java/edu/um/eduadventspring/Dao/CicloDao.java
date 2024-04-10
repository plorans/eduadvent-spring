package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Ciclo;

@Repository
public interface CicloDao extends JpaRepository<Ciclo, Long> {

        @Query(value = "SELECT CICLO_ID, CICLO_NOMBRE, F_CREADA, F_INICIAL, F_FINAL, NUM_CURSOS, ESTADO, ESCALA, "
                        + " MODULOS, EDITAR_ACTIVIDAD, CICLO_ESCOLAR, DECIMALES, REDONDEO, NIVEL_EVAL, NIVEL_ACADEMICO_SISTEMA"
                        +
                        " FROM CICLO" +
                        " WHERE CICLO_ID IN (SELECT CICLO_ID" +
                        " FROM CICLO_GRUPO" +
                        " WHERE CICLO_GRUPO_ID IN (SELECT CICLO_GRUPO_ID" +
                        " FROM KRDX_CURSO_ACT" +
                        " WHERE CODIGO_ID = $1)) ORDER BY $2", nativeQuery = true)
        Long[] getListCiclosAlumno(String codigoId, String orden);

        Ciclo findByCicloId(String cicloId);

        @Query(value = "SELECT COALESCE(MAX(SUBSTR(CICLO_GRUPO_ID,1,8)),'0') " +
                        "AS CICLO_ID FROM CICLO_GRUPO_CURSO WHERE EMPLEADO_ID = :codigoId", nativeQuery = true)
        String getMejorCarga(String codigoId);

        @Query(value = "SELECT CICLO_ID FROM CICLO " +
                        "WHERE SUBSTR(CICLO_ID,1,3) = :escuelaId "
                        + "AND NOW() BETWEEN F_INICIAL AND F_FINAL", nativeQuery = true)
        String getMejorCargaNow(String escuelaId);

        @Query(value = "SELECT CICLO_ID AS CICLO FROM CICLO " +
                        " WHERE SUBSTR(CICLO_ID,1,3) = :escuelaId " +
                        " AND NOW() BETWEEN F_INICIAL AND F_FINAL", nativeQuery = true)
        String getCargaNow(String escuelaId);

        @Query(value = "SELECT MAX(CICLO_ID) AS CICLO FROM CICLO" +
                        " WHERE SUBSTR(CICLO_ID,1,3) = :escuelaId", nativeQuery = true)
        String getCargaActual(String escuelaId);

        @Query(value = "SELECT CICLO_ID FROM CICLO WHERE SUBSTR(CICLO_ID,1,3) = :escuelaId AND ( NOW() BETWEEN F_INICIAL AND F_FINAL)", nativeQuery = true)
        String getCargaEscuelaNow(String escuelaId);

        @Query(value = "SELECT COALESCE(MAX(CICLO_ID),'XXXXXXX') AS CICLO FROM CICLO WHERE SUBSTR(CICLO_ID,1,3) = :escuelaId", nativeQuery = true)
        String getCargaEscuela(String escuelaId);

}
