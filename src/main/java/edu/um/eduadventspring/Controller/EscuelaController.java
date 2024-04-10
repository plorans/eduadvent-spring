package edu.um.eduadventspring.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.um.eduadventspring.Manager.CicloManager;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Manager.FinEjercicioManager;
import edu.um.eduadventspring.Manager.UserManager;
import edu.um.eduadventspring.Model.Escuela;
import edu.um.eduadventspring.Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parametros/escuela")
@Slf4j
public class EscuelaController {

    @Autowired
    private EscuelaManager escuelaManager;

    @Autowired
    private CicloManager cicloManager;

    @Autowired
    private FinEjercicioManager finEjercicioManager;

    @GetMapping()
    public ModelAndView getEscuelas() {
        List<Escuela> lisEscuela = escuelaManager.getEscuelas().collectList().block();

        ModelAndView modelAndView = new ModelAndView("escuela/parametros/escuela/escuela");
        modelAndView.addObject("escuelas", lisEscuela);

        return modelAndView;
    }

    @PostMapping("/subir")
    public ModelAndView subirEscuela(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Escuela> lisEscuela = escuelaManager.getEscuelas().collectList().block();
        ModelAndView modelAndView = new ModelAndView();
        HttpSession session = request.getSession();
        String resultado = "";

        String escuelaId = request.getParameter("EscuelaId");
        String accion = request.getParameter("Accion") == null ? "1" : request.getParameter("Accion");
        int numAccion = Integer.parseInt(accion);

        switch (numAccion) {
            case 1: {
                if (lisEscuela.size() > 0)
                    resultado = "ClickNombreEscuela";
                else
                    resultado = "NoEncontro";
                break;
            }
            case 2: {
                if (escuelaId.length() == 1) {
                    escuelaId = "0" + escuelaId;
                } else {
                    escuelaId = request.getParameter("EscuelaId");
                }

                session.setAttribute("escuela", escuelaId);
                session.setAttribute("cicloId", cicloManager.getMejorCargaEscuela(escuelaId));
                resultado = "RegistradoentuSesion";

                String ejercicioId = finEjercicioManager.getEjercicioActual(escuelaId);
                session.setAttribute("ejercicioId", ejercicioId);


                break;
            }
        }


        modelAndView.addObject("resultado", resultado);
        modelAndView.addObject("escuelas", lisEscuela);
        modelAndView.setViewName("redirect:/inicio");
        return modelAndView;
    }

    // @PostMapping("/save")
    // public ModelAndView saveEscuela(Escuela escuela){
    // manager.saveEscuela(escuela).subscribe();
    // return new ModelAndView("redirect:/escuela");
    // }

    // @DeleteMapping("/{id}/remove")
    // public ModelAndView removeEscuela(@PathVariable Long id){
    // manager.removeEscuela(id).subscribe();
    // return new ModelAndView("redirect:/escuela");
    // }

    // @GetMapping("/{id}")
    // public ModelAndView getEscuela(@PathVariable Long id){
    // ModelAndView modelAndView = new ModelAndView("escuela-details");
    // manager.getEscuela(id).subscribe(escuela -> modelAndView.addObject("escuela",
    // escuela));
    // return modelAndView;
    // }

}
