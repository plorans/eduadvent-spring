package edu.um.eduadventspring.ManagerImpl;

import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import edu.um.eduadventspring.Dao.FinEjercicioDao;
import edu.um.eduadventspring.Manager.FinEjercicioManager;
import edu.um.eduadventspring.Model.FinEjercicio;
import lombok.extern.slf4j.Slf4j;

@Service("FinEjercicioManager")
@Slf4j
public class FinEjercicioImpl implements FinEjercicioManager{

    @Autowired
    private FinEjercicioDao finEjercicioDao;

    @Override
    public String getEjercicioActual(String escuelaId) {
        Long id = finEjercicioDao.getEjercicioActualDao(escuelaId);

        FinEjercicio actual = finEjercicioDao.findById(id).orElseThrow();
        return actual.getEjercicioId();
    }
    
}
