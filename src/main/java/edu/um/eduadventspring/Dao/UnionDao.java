package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Union;

@Repository
public interface UnionDao extends JpaRepository<Union,Long> {
    
}
