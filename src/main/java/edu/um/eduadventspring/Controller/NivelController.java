package edu.um.eduadventspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.um.eduadventspring.Manager.NivelManager;
import edu.um.eduadventspring.Model.Nivel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/nivel")
public class NivelController {
    
    @Autowired
    private NivelManager nivelManager;

    @PostMapping()
    public Mono<Nivel> saveNivel(@RequestBody Nivel nivel){
        return nivelManager.saveNivel(nivel);
    }

    @DeleteMapping("/{id}")
    public Mono<Nivel> removeNivel(@PathVariable Long id){
        return nivelManager.deleteNivel(id);
    }

    @GetMapping("/{id}")
    public Mono<Nivel> getNivel(@PathVariable Long id){
        return nivelManager.getNivel(id);
    }

    @GetMapping()
    public Flux<Nivel> getNiveles(){
        return nivelManager.getNiveles();
    }
}
