package edu.um.eduadventspring.ManagerImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.CicloDao;
import edu.um.eduadventspring.Manager.CicloManager;
import edu.um.eduadventspring.Model.Ciclo;
import lombok.extern.slf4j.Slf4j;

@Service("CicloManager")
@Slf4j
public class CicloManagerImpl implements CicloManager {

    @Autowired
    private CicloDao cicloDao;

    @Override
    public List<Ciclo> getListCiclosAlumno(String codigoId, String orden) {
        Long[] listaId = cicloDao.getListCiclosAlumno(codigoId, orden);
        List<Ciclo> ciclos = new ArrayList<Ciclo>();

        for (int i = 0; i < listaId.length; i++) {
            Ciclo salida = cicloDao.findById(listaId[i]).orElseThrow();
            ciclos.add(salida);
        }
        return ciclos;
    }

    @Override
    public String getMejorCarga(String codigoId) {
        String ciclo = cicloDao.getMejorCarga(codigoId);
        String mejorCiclo = "XXXXXXX";
        if (!ciclo.equals("0")) {
            mejorCiclo = ciclo;
        } else {
            mejorCiclo = cicloDao.getMejorCargaNow(codigoId.substring(0,3));
        }
        return mejorCiclo;
    }

    @Override
    public String getCargaActual(String escuelaId) {
        String cargaActual;
        String carga = cicloDao.getCargaNow(escuelaId);

        if (!carga.isEmpty()) {
            cargaActual = carga;
        } else {
            cargaActual = cicloDao.getCargaActual(escuelaId);
        }
        return cargaActual;
    }

    @Override
    public String getMejorCargaEscuela(String escuelaId) {
        String carga = cicloDao.getCargaEscuelaNow(escuelaId);
        String cargaActual = "XXXXXXX";

        if (!carga.equals("0")) {
            cargaActual = carga;
        } else {
            cargaActual = cicloDao.getCargaEscuela(escuelaId);
        }

        return cargaActual;

    }

}
