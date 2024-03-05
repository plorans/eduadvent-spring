package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.AlumPersonal;

public interface AlumPersonalManager {
    
    String getNombre(String codigoId, String opcion);

    Boolean alumPersonalExist(String codigoId);
}
