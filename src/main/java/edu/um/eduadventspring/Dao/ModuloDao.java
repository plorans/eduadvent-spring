package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Modulo;
import java.util.List;

@Repository
public interface ModuloDao extends JpaRepository<Modulo, Long> {

    @Query(value = "SELECT MODULO_ID FROM MODULO " +
            "WHERE MODULO_ID IN " +
            "(SELECT DISTINCT(A.MODULO_ID) " +
            "FROM MODULO_OPCION A, USUARIO_MENU B " +
            "WHERE B.OPCION_ID = A.OPCION_ID " +
            "AND B.CODIGO_ID = :codigoId) " +
            " ORDER BY 1", nativeQuery = true)
    String[] getListUserSuper(String codigoId);

    Modulo findByModuloId(String moduloId);

    @Query(value = "SELECT MODULO_ID FROM MODULO " +
            "WHERE MODULO_ID IN " +
            "(SELECT DISTINCT(A.MODULO_ID) " +
            "FROM MODULO_OPCION A, USUARIO_MENU B " +
            "WHERE B.OPCION_ID = A.OPCION_ID " +
            "AND B.CODIGO_ID = :codigoId " +
            " AND A.ESTADO = 'A' )" +
            " ORDER BY 1", nativeQuery = true)
    String[] getListUser(String codigoId);

}
