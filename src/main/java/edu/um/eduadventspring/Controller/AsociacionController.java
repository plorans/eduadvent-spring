package edu.um.eduadventspring.Controller;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import oracle.net.aso.m;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import edu.um.eduadventspring.Manager.AsociacionManager;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Manager.UnionManager;
import edu.um.eduadventspring.Model.Asociacion;
import edu.um.eduadventspring.Model.Escuela;
import edu.um.eduadventspring.Model.Union;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/catalogo")
@Slf4j
public class AsociacionController {

    @Autowired
    private UnionManager unionManager;

    @Autowired
    private AsociacionManager asociacionManager;

    @Autowired
    private EscuelaManager escuelaManager;

    @GetMapping("/asociacion")
    public ModelAndView getAsociacion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView();
        HttpSession session = request.getSession();
        List<Union> uniones = unionManager.getUnionList();
        Collections.sort(uniones, new Comparator<Union>() {
            @Override
            public int compare(Union un1, Union un2) {
                return un1.getId().compareTo(un2.getId());
            }
        });

        String mensaje = (String) session.getAttribute("mensaje");
        String unionId = "";
        try {
            unionId = (String) request.getParameter("unionId");
        } catch (Exception e) {
        }
        List<Asociacion> asociaciones;
        if (unionId != null && !unionId.equals("")) {
            asociaciones = asociacionManager.getAsociacionesByUnion(Long.valueOf(unionId));
            mnv.addObject("unionId", "");
        } else {
            asociaciones = asociacionManager.getAsociacionesByUnion(uniones.get(0).getId());
            mnv.addObject("unionId", String.valueOf(uniones.get(0).getId()));

        }

        Collections.sort(asociaciones, new Comparator<Asociacion>() {
            @Override
            public int compare(Asociacion as1, Asociacion as2) {
                return as1.getId().compareTo(as2.getId());
            }
        });


        if (mensaje != null) {
            switch (mensaje) {
                case "Guardado":
                    mnv.addObject("msj", "Guardado");
                    break;
                case "Borrado":
                    mnv.addObject("msj", "Borrado");
                    break;
                case "error":
                    mnv.addObject("msj", "Error");
                    break;
                default:
                    break;
            }
        }

        mnv.addObject("uniones", uniones);
        mnv.addObject("asociaciones", asociaciones);

        mnv.setViewName("escuela/catalogo/asociacion/asociacion");
        return mnv;
    }

    @GetMapping("/asociacion/accion")
    public ModelAndView getAccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView("escuela/catalogo/asociacion/accion");
        Asociacion asociacion = new Asociacion();
        String accion = request.getParameter("accion");
        String unionId = request.getParameter("unionId");
        String asociacionId = request.getParameter("asocId");
        List<Union> unionL = unionManager.getUnionList();

        Collections.sort(unionL, new Comparator<Union>() {
            @Override
            public int compare(Union un1, Union un2) {
                return un1.getNombre().compareTo(un2.getNombre());
            }
        });

        if (accion.equals("1")) {// Nuevo
            java.util.HashMap<String, edu.um.eduadventspring.Model.Asociacion> asocs = asociacionManager
                    .getAsociacionesMap();
            String id = "";

            for (int i = 1; i < 100; i++) {
                if (asocs.containsKey(i + "")) {
                    // Este no
                } else {
                    // Este si
                    id = i + "";
                    break;
                }
            }

            Union union = unionManager.getUnionById(Long.valueOf(unionId));

            asociacion.setId(Long.valueOf(id));
            asociacion.setNombre("");
            asociacion.setFondoId("");
            asociacion.setNCorto("");
            asociacion.setUnion(union);

            mnv.addObject("asocs", id);
        } else if (accion.equals("4")) {// Editar
            asociacion = asociacionManager.getAsociacionById(Long.valueOf(asociacionId));
        }
        mnv.addObject("unionL", unionL);
        mnv.addObject("asociacion", asociacion);
        return mnv;

    }

    @PostMapping("/asociacion/accion")
    public ModelAndView postAccion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView mnv = new ModelAndView();
        HttpSession session = request.getSession();
        String accion = (String) request.getParameter("accion");
        String unionId = (String) request.getParameter("unionId");
        String asociacionId = (String) request.getParameter("asocId");
        String fondoId = (String) request.getParameter("fondoId");
        String nCorto = (String) request.getParameter("asocNombreCorto");
        String nombre = (String) request.getParameter("AsocNombre");
        Asociacion asociacion = new Asociacion();

        if (accion.equals("2")) {// Grabar
            asociacion.setId(Long.valueOf(asociacionId));
            asociacion.setNombre(nombre);
            Union asocUnion = unionManager.getUnionById(Long.valueOf(unionId));
            asociacion.setUnion(asocUnion);
            if (fondoId.equals("")) {
                asociacion.setFondoId("-");
            } else {
                asociacion.setFondoId(fondoId);
            }
            asociacion.setNCorto(nCorto);
            asociacionManager.saveAsociacion(asociacion);

            session.setAttribute("mensaje", "Guardado");

            mnv.setViewName("redirect:/catalogo/asociacion?unionId=" + unionId);

        } else if (accion.equals("3")) {
            List<Escuela> escuelas = escuelaManager.getEscuelasByAsociacion(asociacion.getId());
            if (escuelas.size() == 0) {
                asociacionManager.deleteAsociacion(Long.valueOf(asociacionId));
            }
            session.setAttribute("mensaje", "Borrado");

            mnv.setViewName("redirect:/catalogo/asociacion?unionId=" + unionId);
        }
        return mnv;
    }

    @PostMapping("/asociacion/mensaje")
    public void mensaje(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.removeAttribute("mensaje");

    }

}
