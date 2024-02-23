package edu.um.eduadventspring.Manager;

public interface EmpPersonalManager {
    
    boolean getEstadoEmp(String codigoId);

    String getNombre(String codigoId, String opcion);
}
