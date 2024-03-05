package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.um.eduadventspring.Model.EmpPersonal;



public interface EmpPersonalDao extends JpaRepository<EmpPersonal,Long>{

    EmpPersonal findByCodigoId(String codigoId);

    boolean existsByCodigoId(String codigoId);
}
