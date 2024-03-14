package edu.um.eduadventspring.ManagerImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.MenuDao;
import edu.um.eduadventspring.Manager.MenuManager;
import edu.um.eduadventspring.Model.Menu;

@Service("MenuManager")
public class MenuManagerImpl implements MenuManager{

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<Menu> getMenu(String codigoId) {        
        Long[] listaId = menuDao.getListUser(codigoId);
        List<Menu> menus = new ArrayList<Menu>();

        for(int i = 0; i < listaId.length; i++){
            Menu salida = menuDao.findById(listaId[i]).orElseThrow();            
            menus.add(salida);
        }
        return menus;
    }
    
}
