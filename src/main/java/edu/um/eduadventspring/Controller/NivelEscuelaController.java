package edu.um.eduadventspring.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Manager.GrupoManager;
import edu.um.eduadventspring.Manager.NivelEscuelaManager;
import edu.um.eduadventspring.Model.Escuela;
import edu.um.eduadventspring.Model.NivelEscuela;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequestMapping("/catalogo/nivel")
@Slf4j
public class NivelEscuelaController {

    @Autowired
    private NivelEscuelaManager nivelEscuelaManager;
    @Autowired
    private EscuelaManager escuelaManager;
    @Autowired
    private GrupoManager grupoManager;

    @GetMapping()
    public ModelAndView getNivelesEscuela(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ModelAndView modelAndView = new ModelAndView("escuela/catalogo/nivel/nivel");

        HttpSession session = request.getSession();
        String escuelaid = (String) session.getAttribute("escuela");
        Mono<Escuela> escuelaMono = escuelaManager.getEscuela(escuelaid);
        Escuela escuelaN = escuelaMono.block();
        //log.info("Escuela: " + escuelaN);

        List<NivelEscuela> niveles = nivelEscuelaManager.getNivelesEscuela(escuelaid, "nivel.id").collectList().block();
        modelAndView.addObject("escuelaN", escuelaN);

        for (NivelEscuela nivelEscuela : niveles) {
            if(nivelEscuela.getEscuela().getEscuelaId().equals(escuelaid)){
                //log.info("Nivel: " + nivelEscuela);
            }
            if (!grupoManager.existeNivel(escuelaN.getNombre(), nivelEscuela.getId())) {
                nivelEscuela.setExisteNivel(true);
            }
        }

        modelAndView.addObject("niveles", niveles);


        return modelAndView;
    }

    // @PostMapping()
    // public Mono<NivelEscuela> saveNivelEscuela(@RequestBody NivelEscuela
    // nivelEscuela){
    // return nivelEscuelaManager.saveNivelEscuela(nivelEscuela);
    // }

    // @DeleteMapping("/{id}")
    // public Mono<NivelEscuela> removeNivelEscuela(@PathVariable Long id){
    // return nivelEscuelaManager.deleteNivelEscuela(id);
    // }

    // @GetMapping("/{id}")
    // public Mono<NivelEscuela> getNivelEscuela(@PathVariable Long id){
    // return nivelEscuelaManager.getNivelEscuela(id);
    // }

}
