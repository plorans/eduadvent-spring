package edu.um.eduadventspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.um.eduadventspring.Manager.AsociacionManager;
import edu.um.eduadventspring.Manager.CiudadManager;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Manager.EstadoManager;
import edu.um.eduadventspring.Manager.PaisManager;
import edu.um.eduadventspring.Model.Escuela;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/parametros/escuela")
@Slf4j
public class EscuelaController {
    
    @Autowired
    private EscuelaManager escuelaManager;
    @Autowired
    private PaisManager paisManager;
    @Autowired
    private CiudadManager ciudadManager;
    @Autowired
    private AsociacionManager asociacionManager;
    @Autowired
    private EstadoManager estadoManager;

    @GetMapping()
    public ModelAndView getEscuelas(){
        ModelAndView modelAndView = new ModelAndView("escuela/parametros/escuela/escuela");
        modelAndView.addObject("escuelas", escuelaManager.getEscuelas().collectList().block());

        
        return modelAndView;
    }

    // @PostMapping("/save")
    // public ModelAndView saveEscuela(Escuela escuela){
    //     manager.saveEscuela(escuela).subscribe();
    //     return new ModelAndView("redirect:/escuela");
    // }

    // @DeleteMapping("/{id}/remove")
    // public ModelAndView removeEscuela(@PathVariable Long id){
    //     manager.removeEscuela(id).subscribe();
    //     return new ModelAndView("redirect:/escuela");
    // }

    // @GetMapping("/{id}")
    // public ModelAndView getEscuela(@PathVariable Long id){
    //     ModelAndView modelAndView = new ModelAndView("escuela-details");
    //     manager.getEscuela(id).subscribe(escuela -> modelAndView.addObject("escuela", escuela));
    //     return modelAndView;
    // }

    
    
}
