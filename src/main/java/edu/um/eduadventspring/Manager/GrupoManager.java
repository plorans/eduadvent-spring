package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.Grupo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GrupoManager {
    
    Mono<Grupo> saveGrupo(Grupo grupo);

    Mono<Grupo> getGrupo(Long id);

    Flux<Grupo> getGrupos();

    Mono<Grupo> deleteGrupo(Long id);

    Boolean existeNivel(String escuelaId, Long nivelId);
}
