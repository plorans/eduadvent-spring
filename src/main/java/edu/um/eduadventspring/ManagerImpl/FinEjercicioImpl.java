package edu.um.eduadventspring.ManagerImpl;

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
    public String getEjercicioActual(String escuelaId) {
        Long id = finEjercicioDao.getEjercicioActualDao(escuelaId);

        FinEjercicio actual = finEjercicioDao.findById(id).orElseThrow();
        return actual.getEjercicioId();
    }
    
}
