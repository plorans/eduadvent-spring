package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.EmpPersonal;

public interface EmpPersonalManager {
    
    boolean getEstadoEmp(String codigoId);

    String getNombre(String codigoId, String opcion);

    EmpPersonal getEmpPersonal(String codigoId);

    boolean existByCodigoId(String codigoId);
}
