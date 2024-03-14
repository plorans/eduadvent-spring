package edu.um.eduadventspring.Manager;

import java.util.HashMap;
import java.util.List;

import edu.um.eduadventspring.Model.Ciudad;

public interface CiudadManager {

    List<Ciudad> getCiudades();

    HashMap<String, Ciudad> getCiudadesMap();

}
