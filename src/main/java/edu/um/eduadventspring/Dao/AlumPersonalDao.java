package edu.um.eduadventspring.Dao;

import org.eclipse.tags.shaded.org.apache.xpath.operations.Bool;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.AlumPersonal;

@Repository
public interface AlumPersonalDao extends JpaRepository<AlumPersonal,Long>{
    
    AlumPersonal findByCodigoId(String codigoId);

    Boolean existsByCodigoId(String codigoId);
    
}
