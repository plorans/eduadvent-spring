package edu.um.eduadventspring.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.um.eduadventspring.Manager.GrupoManager;
import edu.um.eduadventspring.Model.Grupo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/grupo")
public class GrupoController {

    @Autowired
    private GrupoManager grupoManager;

    @PostMapping()
    public Mono<Grupo> saveGrupo(@RequestBody Grupo Grupo) {
        return grupoManager.saveGrupo(Grupo);
    }

    @DeleteMapping("/{id}")
    public Mono<Grupo> removeGrupo(@PathVariable Long id) {
        return grupoManager.deleteGrupo(id);
    }

    @GetMapping("/{id}")
    public Mono<Grupo> getGrupo(@PathVariable Long id) {
        return grupoManager.getGrupo(id);
    }

    @GetMapping()
    public Flux<Grupo> getGrupos() {
        return grupoManager.getGrupos();
    }
}
