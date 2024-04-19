package edu.um.eduadventspring.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Escuela;



@Repository
public interface EscuelaDao extends JpaRepository<Escuela, Long> {

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query("UPDATE Escuela e SET e.estado = :estado WHERE e.id = :id")
    int updateEstado(@Param("estado") char estado, @Param("id") Long id);

    Escuela findByEscuelaId(String escuelaId);

    List<Escuela> findByAsociacionId_Id(Long asociacionId);
}

