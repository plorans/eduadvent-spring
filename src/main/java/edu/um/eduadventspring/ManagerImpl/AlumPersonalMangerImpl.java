package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.AlumPersonalDao;
import edu.um.eduadventspring.Manager.AlumPersonalManager;
import edu.um.eduadventspring.Model.AlumPersonal;

@Service
public class AlumPersonalMangerImpl implements AlumPersonalManager{

   @Autowired
   private AlumPersonalDao alumPersonalDao; 

    @Override
    public String getNombre(String codigoId, String opcion) {
        AlumPersonal personal = alumPersonalDao.findByCodigoId(codigoId);
        String nombre = "";
        if(opcion.equals("NOMBRE")){
            nombre = personal.getNombre() + " " + personal.getApaterno() + " " + personal.getAmaterno();
        }else{
            nombre = personal.getApaterno() + " " + personal.getAmaterno() + " " + personal.getNombre();
        }
        return nombre;
    }
    
}
