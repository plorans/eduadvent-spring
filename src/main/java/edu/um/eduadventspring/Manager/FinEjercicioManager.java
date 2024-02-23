package edu.um.eduadventspring.Manager;

import java.sql.Date;

public interface FinEjercicioManager {

    String getEjercicioActual(String escuelaId, Date fechaIni, Date fechaFin);
}

