package edu.um.eduadventspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.um.eduadventspring.Manager.GradoManager;
import edu.um.eduadventspring.Model.Grado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/grado")
public class GradoController {
    
    @Autowired
    private GradoManager gradoManager;

    @PostMapping()
    public Mono<Grado> saveGrado(@RequestBody Grado grado){
        return gradoManager.saveGrado(grado);
    }

    @DeleteMapping("/{id}")
    public Mono<Grado> removeGrado(@PathVariable Long id){
        return gradoManager.deleteGrado(id);
    }

    @GetMapping("/{id}")
    public Mono<Grado> getGrado(@PathVariable Long id){
        return gradoManager.getGrado(id);
    }

    @GetMapping()
    public Flux<Grado> getGrados(){
        return gradoManager.getGrados();
    }
}
