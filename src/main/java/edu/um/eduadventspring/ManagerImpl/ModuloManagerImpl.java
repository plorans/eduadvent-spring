package edu.um.eduadventspring.ManagerImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.ModuloDao;
import edu.um.eduadventspring.Manager.ModuloManager;
import edu.um.eduadventspring.Model.Modulo;

@Service("ModuloManager")
public class ModuloManagerImpl implements ModuloManager{

    @Autowired
    private ModuloDao moduloDao;

    @Override
    public List<Modulo> getListUserSuper(String codigoId) {
        String[] listaId = moduloDao.getListUserSuper(codigoId);
        List<Modulo> modulos = new ArrayList<Modulo>();

        for(int i = 0; i < listaId.length; i++){
            Modulo salida = moduloDao.findByModuloId(listaId[i]);
            modulos.add(salida);
        }
        return modulos;
    }

    @Override
    public List<Modulo> getListUser(String codigoId) {
        String[] listaId = moduloDao.getListUser(codigoId);
        List<Modulo> modulos = new ArrayList<Modulo>();

        for(int i = 0; i < listaId.length; i++){
            Modulo salida = moduloDao.findByModuloId(listaId[i]);
            modulos.add(salida);
        }
        return modulos;
    }
    
}
