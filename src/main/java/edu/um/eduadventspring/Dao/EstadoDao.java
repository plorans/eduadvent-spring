package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Estado;

@Repository
public interface EstadoDao extends JpaRepository<Estado,Long>{
    
}
