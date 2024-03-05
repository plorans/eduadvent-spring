package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.CicloGrupoCursoDao;
import edu.um.eduadventspring.Manager.CicloGrupoCursoManager;

@Service("CicloGrupoCursoManager")
public class CicloGrupoCursoManagerImpl implements CicloGrupoCursoManager {

    @Autowired
    private CicloGrupoCursoDao cicloGrupoCursoDao;

    @Override
    public Boolean existeMAestro(String empleadoId) {
        return cicloGrupoCursoDao.existsByEmpleadoId(empleadoId);
    }

}
