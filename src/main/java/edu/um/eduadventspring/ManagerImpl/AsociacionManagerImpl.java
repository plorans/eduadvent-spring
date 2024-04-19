package edu.um.eduadventspring.ManagerImpl;

import java.util.HashMap;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.AsociacionDao;
import edu.um.eduadventspring.Manager.AsociacionManager;
import edu.um.eduadventspring.Model.Asociacion;

@Service("AsociacionManager")
public class AsociacionManagerImpl implements AsociacionManager {

    @Autowired
    private AsociacionDao asociacionDao;

    @Override
    public HashMap<String, Asociacion> getAsociacionesMap() {
        List<Asociacion> asociacionList = asociacionDao.findAll();

        HashMap<String, Asociacion> map = new HashMap<>();
        for (Asociacion asociacion : asociacionList) {
            map.put(String.valueOf(asociacion.getId()), asociacion);
        }

        return map;
    }

    @Override
    public List<Asociacion> getAsociaciones() {
        return asociacionDao.findAll();
    }

    @Override
    public List<Asociacion> getAsociacionesByUnion(Long unionId) {
        return asociacionDao.findByUnion_Id(unionId);
    }

    @Override
    public Asociacion saveAsociacion(Asociacion asociacion) {
        return asociacionDao.save(asociacion);
    }

    @Override
    public void deleteAsociacion(Long asociacion) {
        asociacionDao.deleteById(asociacion);
    }

    @Override
    public Asociacion getAsociacionById(Long id) {
        return asociacionDao.findById(id).orElseThrow();
    }

}
