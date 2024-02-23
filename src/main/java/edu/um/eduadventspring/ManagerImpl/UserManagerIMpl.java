package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.UserDao;
import edu.um.eduadventspring.Manager.UserManager;
import edu.um.eduadventspring.Model.User;

@Service("UserManager")
public class UserManagerIMpl implements UserManager{

    @Autowired
    private UserDao userDao;

    @Override
    public String getCodigoId(String username, String password) {
        User usuario = userDao.findByUsuarioAndPasswordAndEscuelaContaining(username, password, password);
        if(usuario != null){
            return usuario.getCodigoId();
        }else{
            return "x";
        }
        
    }

    @Override
    public Boolean esAdministrador(String codigoId) {
        boolean admi = false;

        User usuario = userDao.findByCodigoId(codigoId);
        if(usuario.getAdministrador().equals("S")){
            admi = true;
        }
        return admi;
    }

    @Override
    public String getIdioma(String codigoId) {
        User usuario = userDao.findByCodigoId(codigoId);
        return usuario.getIdioma();
    }

    @Override
    public Integer getTipo(String codigoId) {
        User usuario = userDao.findByCodigoId(codigoId);
        return usuario.getTipoId();
    }

    @Override
    public Boolean esSuper(String codigoId) {
        User usuario = userDao.findByCodigoId(codigoId);
        boolean sup = false;
        if(usuario.getSup() == 'S'){
            sup = true;
        }
        return sup;
    }

    
}