package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.Escuela;

public interface EscuelaManager {
    
    Character getEstadoEscuela(String escuelaId);

    String getNombre(String escuela);
}
