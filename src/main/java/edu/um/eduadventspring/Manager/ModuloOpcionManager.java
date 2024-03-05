package edu.um.eduadventspring.Manager;

import java.util.List;

import edu.um.eduadventspring.Model.ModuloOpcion;

public interface ModuloOpcionManager {
    
    List<ModuloOpcion> getListUserSuper(String codigoid);


    List<ModuloOpcion> getListUser(String codigoid);


}
