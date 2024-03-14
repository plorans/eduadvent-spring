package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.ModuloOpcion;


@Repository
public interface ModuloOpcionDao extends JpaRepository<ModuloOpcion, Long> {

    @Query(value = "SELECT A.ID " +
            "FROM MODULO_OPCION A, USUARIO_MENU B " +
            "WHERE B.OPCION_ID = A.OPCION_ID " +
            "AND B.CODIGO_ID = :codigoId ", nativeQuery = true)
    Integer[] getListUserSuper(String codigoId);

    @Query(value = "SELECT A.ID " +
            "FROM MODULO_OPCION A, USUARIO_MENU B " +
            "WHERE B.OPCION_ID = A.OPCION_ID " +
            "AND B.CODIGO_ID = :codigoId " +
            "AND A.ESTADO = 'A'", nativeQuery = true)
    Integer[] getListUser(String codigoId);
}
