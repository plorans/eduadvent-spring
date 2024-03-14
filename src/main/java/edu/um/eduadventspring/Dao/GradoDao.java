package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Grado;

@Repository
public interface GradoDao extends JpaRepository<Grado, Long>{
    
}
