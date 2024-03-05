package edu.um.eduadventspring.ManagerImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.ModuloOpcionDao;
import edu.um.eduadventspring.Manager.ModuloOpcionManager;
import edu.um.eduadventspring.Model.ModuloOpcion;
import lombok.extern.slf4j.Slf4j;

@Service("ModuloOpcionManager")
@Slf4j
public class ModuloOpcionManagerImpl implements ModuloOpcionManager {

    @Autowired
    private ModuloOpcionDao moduloOpcionDao;

    @Override
    public List<ModuloOpcion> getListUserSuper(String codigoId) {
        log.info("codigoid: " + codigoId);

        Integer[] mOpcionId = moduloOpcionDao.getListUserSuper(codigoId);
        log.info("ModulosOpcion: " + mOpcionId[0]);

        List<ModuloOpcion> modulos = new ArrayList<>();

        log.info("Length : " + mOpcionId.length);

        for (int i = 0; i < mOpcionId.length; i++) {
            ModuloOpcion salida = moduloOpcionDao.findById(mOpcionId[i].longValue()).orElseThrow();

            modulos.add(salida);
        }
        log.info("modulos : " + modulos.get(0));
        return modulos;
    }

    @Override
    public List<ModuloOpcion> getListUser(String codigoId) {
        List<ModuloOpcion> modulos = new ArrayList<>();
        Integer[] mOpcionId = moduloOpcionDao.getListUserSuper(codigoId);

        for (int i = 0; i < mOpcionId.length; i++) {
            ModuloOpcion salida = moduloOpcionDao.findById(mOpcionId[i].longValue()).orElseThrow();
            modulos.add(salida);
        }

        return modulos;
    }

}
