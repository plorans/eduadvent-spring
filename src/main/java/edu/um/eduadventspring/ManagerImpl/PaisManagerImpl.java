package edu.um.eduadventspring.ManagerImpl;

import java.util.HashMap;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.PaisDao;
import edu.um.eduadventspring.Manager.PaisManager;
import edu.um.eduadventspring.Model.Pais;

@Service("PaisManager")
public class PaisManagerImpl implements PaisManager {

    @Autowired
    private PaisDao paisDao;

    @Override
    public List<Pais> getPaises() {
        return paisDao.findAll();
    }

    @Override
    public HashMap<String, Pais> getPaisesMap() {
        List<Pais> paisList = paisDao.findAll(); 

        HashMap<String, Pais> map = new HashMap<>();
        for (Pais pais : paisList) {
            map.put(String.valueOf(pais.getId()), pais);
        }

        return map;
    }

}
