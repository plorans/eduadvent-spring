package edu.um.eduadventspring.Manager;

public interface UserManager {
    
    String getCodigoId(String usuario, String password);

    Boolean esAdministrador(String codigoId);

    String getIdioma(String codigoId);

    Integer getTipo(String codigoId);

    Boolean esSuper(String codigoId);
}
