package edu.um.eduadventspring.Manager;

import java.util.List;

import edu.um.eduadventspring.Model.Menu;

public interface MenuManager {
    
    List<Menu> getMenu(String codigoId);
}
