package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EscuelaDao;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Model.Escuela;

@Service("EscuelaManager")
public class EscuelaManagerImpl implements EscuelaManager{

    @Autowired
    private EscuelaDao escuelaDao;

    @Override
    public Character getEstadoEscuela(String escuelaId) {
        Escuela salida = escuelaDao.findByEscuelaId(escuelaId);
        return salida.getEstado();
    }

    @Override
    public String getNombre(String escuelaId) {
        Escuela salida = escuelaDao.findByEscuelaId(escuelaId);
        return salida.getNombre();
    }

   
    
}
