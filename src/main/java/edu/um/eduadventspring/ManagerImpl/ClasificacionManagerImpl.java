package edu.um.eduadventspring.ManagerImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.ClasificacionDao;
import edu.um.eduadventspring.Manager.ClasificacionManager;
import edu.um.eduadventspring.Model.Clasificacion;
import lombok.extern.slf4j.Slf4j;

@Service("ClasificacionManager")
@Slf4j
public class ClasificacionManagerImpl implements ClasificacionManager {

    @Autowired
    private ClasificacionDao clasificacionDao;

    @Override
    public ArrayList<Clasificacion> getListByEscuela(String escuelaId) {
        return clasificacionDao.findByEscuela_EscuelaId(escuelaId);
    }

    @Override
    public Integer maximoReg(String escuelaId) {
        return clasificacionDao.maximoReg(escuelaId);
    }

    @Override
    public Boolean deleteReg(String escuelaId, Integer clasfinId) {
        try {
            clasificacionDao.deleteReg(escuelaId, clasfinId);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean existeReg(String escuelaId, Integer clasfinId) {
        return clasificacionDao.existsByEscuela_EscuelaIdAndClasfinId(escuelaId, clasfinId);
    }

    @Override
    public Boolean saveClasificacion(Clasificacion clasificacion) {
        try {
            clasificacionDao.save(clasificacion);
            return true;

        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Clasificacion getClasificacion(String escuelaId, Integer clasfinId) {
        return clasificacionDao.findByEscuela_EscuelaIdAndClasfinId(escuelaId, clasfinId);
    }

}
