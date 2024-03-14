package edu.um.eduadventspring.ManagerImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.CiudadDao;
import edu.um.eduadventspring.Manager.CiudadManager;
import edu.um.eduadventspring.Model.Ciudad;

@Service("CiudadManager")
public class CiudadMangerImpl implements CiudadManager{

    @Autowired
    private CiudadDao ciudadDao;

    @Override
    public HashMap<String, Ciudad> getCiudadesMap() {
        List<Ciudad> ciudadList = ciudadDao.findAll(); 

        HashMap<String, Ciudad> map = new HashMap<>();
        for (Ciudad ciudad : ciudadList) {
            map.put(String.valueOf(ciudad.getId()), ciudad);
        }

        return map;
    }

    @Override
    public List<Ciudad> getCiudades() {
        return ciudadDao.findAll();
    }
    
}
