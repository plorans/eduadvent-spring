package edu.um.eduadventspring.Manager;

import java.util.ArrayList;

import edu.um.eduadventspring.Model.Clasificacion;

public interface ClasificacionManager {

    ArrayList<Clasificacion> getListByEscuela(String escuelaId);

    Integer maximoReg(String escuelaId);

    Boolean deleteReg(String escuelaId, Integer clasfinId);

    Boolean existeReg(String escuelaId, Integer clasfinId);

    Boolean saveClasificacion(Clasificacion clasificacion);

    Clasificacion getClasificacion(String escuelaId, Integer clasfinId);

}
