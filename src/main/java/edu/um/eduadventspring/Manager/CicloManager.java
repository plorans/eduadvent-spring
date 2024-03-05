package edu.um.eduadventspring.Manager;

import java.util.List;

import edu.um.eduadventspring.Model.Ciclo;

public interface CicloManager {
    
    List<Ciclo> getListCiclosAlumno(String codigoId, String orden);

    String getMejorCarga(String codigoId);

    String getCargaActual(String escuelaId);
}
