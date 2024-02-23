package edu.um.eduadventspring.ManagerImpl;

import java.sql.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.um.eduadventspring.Dao.FinEjercicioDao;
import edu.um.eduadventspring.Manager.FinEjercicioManager;
import edu.um.eduadventspring.Model.FinEjercicio;

@Service("FinEjercicioManager")
public class FinEjercicioImpl implements FinEjercicioManager{

    @Autowired
    private FinEjercicioDao finEjercicioDao;

    @Override
    // @Query("SELECT f FROM FinEjercicio f WHERE f.escuelaId = ?1 AND ?2 BETWEEN f.fechaIni AND f.fechaFin")
    public String getEjercicioActual(String escuelaId, Date fechaIni, Date fechaFin) {
        FinEjercicio actual = finEjercicioDao.findByEscuelaIdAndFechaIniLessThanEqualAndFechaFinGreaterThanEqual(escuelaId, fechaIni, fechaFin);
        return actual.getEjercicioId();
    }
    
}
