package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Pais;

@Repository
public interface PaisDao extends JpaRepository<Pais,Long>{
    
}
