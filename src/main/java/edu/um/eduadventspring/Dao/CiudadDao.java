package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Ciudad;

@Repository
public interface CiudadDao extends JpaRepository<Ciudad,Long>{
    
}
