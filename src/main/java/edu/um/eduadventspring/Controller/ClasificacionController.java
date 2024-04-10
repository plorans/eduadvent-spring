package edu.um.eduadventspring.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.um.eduadventspring.Manager.ClasificacionManager;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Model.Clasificacion;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/clasfin")
@Slf4j
public class ClasificacionController {

    @Autowired
    private ClasificacionManager clasificacionManager;

    @Autowired
    private EscuelaManager escuelaManager;

    @GetMapping("/clasificacion")
    public ModelAndView getClasificacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView("escuela/catalogo/clasfin/clasificacion");

        HttpSession session = request.getSession();
        String escuelaId = (String) session.getAttribute("escuela");

        ArrayList<Clasificacion> lisClasfin = clasificacionManager.getListByEscuela(escuelaId);
        Collections.sort(lisClasfin, new Comparator<Clasificacion>() {
            @Override
            public int compare(Clasificacion clasificacion1, Clasificacion clasificacion2) {
                return clasificacion1.getClasfinId().compareTo(clasificacion2.getClasfinId());
            }
        });

        mnv.addObject("lisClasfin", lisClasfin);

        return mnv;
    }

    @GetMapping("/accion")
    public ModelAndView getAccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView("escuela/catalogo/clasfin/accion");
        HttpSession session = request.getSession();
        String accion = (String) request.getParameter("accion");
        Clasificacion clasificacion = new Clasificacion();
        String escuelaId = (String) session.getAttribute("escuela");

        try {
            String stClasfinId = (String) request.getParameter("clasfinId");
            Integer clasfinId = Integer.parseInt(stClasfinId);
            int nAccion = Integer.parseInt(accion);

            if (nAccion == 1) {
                clasificacion.setClasfinId(clasificacionManager.maximoReg(escuelaId));
            } else {
                clasificacion.setEscuela(escuelaManager.getEscuela(escuelaId).block());
                clasificacion.setClasfinId(clasfinId);
            }

            if (accion.equals("5")) {
                if (clasificacionManager.existeReg(escuelaId, clasfinId) == true) {
                    clasificacion = clasificacionManager.getClasificacion(escuelaId, clasfinId);
                    mnv.addObject("resultado", "Consulta");

                }
            }

        } catch (Exception e) {
        }

        if (accion.equals("1")) {
            mnv.addObject("resultado", "");
            clasificacion.setNombre("");
            int id = clasificacionManager.getListByEscuela(escuelaId).size() + 1;
            clasificacion.setClasfinId(id);

        }
        if (accion.equals("4")) {
            mnv.addObject("resultado", "");

        }

        mnv.addObject("clasificacion", clasificacion);
        mnv.addObject("salto", "X");

        return mnv;
    }

    @PostMapping("/accion")
    public ModelAndView postAccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ModelAndView mnv = new ModelAndView();
        HttpSession session = request.getSession();
        String escuelaId = (String) session.getAttribute("escuela");
        String accion = (String) request.getParameter("accion");
        String stClasfinId = (String) request.getParameter("clasfinId");
        log.info("clasfionid: " + stClasfinId);
        Integer clasfinId = Integer.parseInt(stClasfinId);
        String nombre = (String) request.getParameter("nombre");
        String estado = (String) request.getParameter("Estado");

        Clasificacion clasificacion = new Clasificacion();

        int nAccion = Integer.parseInt(accion);

        if (nAccion == 1) {
            clasificacion.setClasfinId(clasificacionManager.maximoReg(escuelaId));
        } else {
            clasificacion.setEscuela(escuelaManager.getEscuela(escuelaId).block());
            clasificacion.setClasfinId(clasfinId);
        }

        String salto = "X";
        String sResultado = "";
        int i = 0;

        // Operaciones a realizar en la pantalla
        switch (nAccion) {

            case 2: { // Grabar
                clasificacion.setEscuela(escuelaManager.getEscuela(escuelaId).block());
                clasificacion.setClasfinId(clasfinId);
                clasificacion.setNombre(nombre);
                clasificacion.setEstado(estado.charAt(0));

                if (clasificacionManager.existeReg(escuelaId, clasfinId) == false) {
                    if (clasificacionManager.saveClasificacion(clasificacion)) {
                        log.info("existe");
                        sResultado = "Guardado";
                        salto = "clasificacion";

                    } else {
                        sResultado = "NoGuardo";
                    }
                } else {
                    log.info("no existe");

                    clasificacion.setId(clasificacionManager.getClasificacion(escuelaId, clasfinId).getId());

                    if (clasificacionManager.saveClasificacion(clasificacion)) {
                        sResultado = "Modificado";

                    } else {
                        sResultado = "NoModifico";
                    }
                }
                break;
            }
            case 4: { // Borrar
                if (clasificacionManager.existeReg(escuelaId, clasfinId) == true) {
                    if (clasificacionManager.deleteReg(escuelaId, clasfinId)) {
                        sResultado = "Eliminado";
                        salto = "clasificacion";

                    } else {
                        sResultado = "NoElimino";
                    }

                } else {
                    sResultado = "NoExiste";
                }
                break;
            }
            case 5: { // Consultar
                if (clasificacionManager.existeReg(escuelaId, clasfinId) == true) {
                    clasificacionManager.getClasificacion(escuelaId, clasfinId);
                    sResultado = "Consulta";
                } else {
                    sResultado = "NoExiste";
                }
                break;
            }
        }

        mnv.addObject("resultado", sResultado);
        mnv.addObject("salto", salto);
        mnv.addObject("Clasificacion", clasificacion);

        mnv.setViewName("redirect:/clasfin/clasificacion");

        return mnv;
    }

}