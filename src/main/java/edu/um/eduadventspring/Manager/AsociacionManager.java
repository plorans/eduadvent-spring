package edu.um.eduadventspring.Manager;

import java.util.HashMap;
import java.util.List;

import edu.um.eduadventspring.Model.Asociacion;

public interface AsociacionManager {

    List<Asociacion> getAsociaciones();

    HashMap<String, Asociacion> getAsociacionesMap();

}
