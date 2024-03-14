package edu.um.eduadventspring.ManagerImpl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EstadoDao;
import edu.um.eduadventspring.Manager.EstadoManager;
import edu.um.eduadventspring.Model.Estado;

@Service("EstadoManager")
public class EstadoManagerImpl implements EstadoManager{

    @Autowired
    private EstadoDao estadoDao;

    @Override
    public HashMap<String, Estado> getEstadosMap() {
        List<Estado> estadoList = estadoDao.findAll(); 

        HashMap<String, Estado> map = new HashMap<>();
        for (Estado estado : estadoList) {
            map.put(String.valueOf(estado.getId()), estado);
        }

        return map;
    }

    @Override
    public List<Estado> getEstados() {
        return estadoDao.findAll();
    }
    
    
}
