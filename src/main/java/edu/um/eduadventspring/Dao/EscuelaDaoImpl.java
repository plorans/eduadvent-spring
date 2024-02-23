package edu.um.eduadventspring.Dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class EscuelaDaoImpl implements EscuelaDaoCustom {

    @Transactional
    @Override
    public int updateEstado(char estado, Long id) {

        return 0; 
    }
}
