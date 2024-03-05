package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.User;

public interface UserManager {
    
    String getCodigoId(String usuario, String escuelaId);

    Boolean esAdministrador(String codigoId);

    String getIdioma(String codigoId);

    Integer getTipo(String codigoId);

    Boolean esSuper(String codigoId);

    User getUser(String codigoId);
}
