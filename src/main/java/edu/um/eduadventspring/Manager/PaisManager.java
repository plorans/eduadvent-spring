package edu.um.eduadventspring.Manager;

import java.util.HashMap;
import java.util.List;

import edu.um.eduadventspring.Model.Pais;

public interface PaisManager {
    
    List<Pais> getPaises();

    HashMap<String, Pais> getPaisesMap();
}
