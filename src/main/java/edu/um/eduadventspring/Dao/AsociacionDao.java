package edu.um.eduadventspring.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.um.eduadventspring.Model.Asociacion;
import java.util.List;


@Repository
public interface AsociacionDao extends JpaRepository<Asociacion, Long>{
    
    List<Asociacion> findByUnion_Id(Long unionId);
}
