package edu.um.eduadventspring.Manager;

import java.util.HashMap;
import java.util.List;

import edu.um.eduadventspring.Model.Asociacion;

public interface AsociacionManager {

    List<Asociacion> getAsociaciones();

    HashMap<String, Asociacion> getAsociacionesMap();

    List<Asociacion> getAsociacionesByUnion(Long union); 

    Asociacion saveAsociacion(Asociacion asociacion);

    void deleteAsociacion(Long asociacion);

    Asociacion getAsociacionById(Long id);

}
