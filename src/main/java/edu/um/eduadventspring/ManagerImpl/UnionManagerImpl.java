package edu.um.eduadventspring.ManagerImpl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EscuelaDao;
import edu.um.eduadventspring.Dao.UnionDao;
import edu.um.eduadventspring.Manager.UnionManager;
import edu.um.eduadventspring.Model.Escuela;
import edu.um.eduadventspring.Model.Union;

@Service("UnionManager")
public class UnionManagerImpl implements UnionManager {

    @Autowired
    private UnionDao unionDao;

    @Autowired
    private EscuelaDao escuelaDao;

    @Override
    public List<Union> getUnionList() {
        List<Union> unionList = unionDao.findAll();

        Collections.sort(unionList, new Comparator<Union>() {
            @Override
            public int compare(Union un1, Union un2) {
                return un1.getId().compareTo(un2.getId());
            }
        });

        return unionList;
    }

    @Override
    public Union getUnionByEscuela(String escuelaId) {
        Escuela escuela = escuelaDao.findByEscuelaId(escuelaId);
        return escuela.getUnion();
    }

}
