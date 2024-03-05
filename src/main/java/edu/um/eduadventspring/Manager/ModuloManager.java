package edu.um.eduadventspring.Manager;

import java.util.List;

import edu.um.eduadventspring.Model.Modulo;

public interface ModuloManager {
    
    List<Modulo> getListUserSuper(String codigoId);

    List<Modulo> getListUser(String codigo);
}
