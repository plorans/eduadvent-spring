package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Nivel;


@Repository
public interface NivelDao extends JpaRepository<Nivel, Long>{
}
