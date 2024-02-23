package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EmpPersonalDao;
import edu.um.eduadventspring.Manager.EmpPersonalManager;
import edu.um.eduadventspring.Model.EmpPersonal;

@Service("PersonalManager")
public class EmpPersonalManageImpl implements EmpPersonalManager{

    @Autowired
    private EmpPersonalDao personalDao;

    @Override
    public boolean getEstadoEmp(String codigoId) {
        boolean activo = false;
        EmpPersonal salida = personalDao.findByCodigoId(codigoId);
        
        if(salida.getEstado().equals('A')){
            activo = true;
        }else if(salida.getEstado().equals('I')){
            activo = false;
        }
        return activo;
    }

    @Override
    public String getNombre(String codigoId, String opcion) {
        EmpPersonal personal = personalDao.findByCodigoId(codigoId);
        String nombre = "-";
        if(opcion.equals("NOMBRE")){
            nombre = personal.getNombre() + " " + personal.getApaterno() + " " + personal.getAmaterno();
        }else{
            nombre = personal.getApaterno() + " " + personal.getAmaterno() + " " + personal.getNombre();
        }
        return nombre;
    }
    
}
