package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Menu;

@Repository
public interface MenuDao extends JpaRepository<Menu, Long> {

	@org.springframework.data.jpa.repository.Query( value = "SELECT MENU_ID " +
			" FROM MENU WHERE MENU_ID IN " +
			"  (SELECT DISTINCT(MENU_ID) FROM MODULO WHERE MODULO_ID " +
			"      IN (SELECT DISTINCT(MODULO_ID) FROM MODULO_OPCION A, USUARIO_MENU B " +
			"           WHERE B.OPCION_ID = A.OPCION_ID " +
			"             AND B.CODIGO_ID = :codigoId AND A.ESTADO = 'A' )) ORDER BY 1"
			, nativeQuery = true)
	Long[] getListUser(@Param("codigoId") String codigoId);

}