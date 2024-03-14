package edu.um.eduadventspring.Manager;

import java.util.HashMap;
import java.util.List;

import edu.um.eduadventspring.Model.Estado;

public interface EstadoManager {

    List<Estado> getEstados();

    HashMap<String, Estado> getEstadosMap();

}
