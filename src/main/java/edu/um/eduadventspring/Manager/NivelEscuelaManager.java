package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.NivelEscuela;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NivelEscuelaManager {
        
    Mono<NivelEscuela> saveNivelEscuela(NivelEscuela nivelEscuela);

    Mono<NivelEscuela> getNivelEscuela(Long id);

    Flux<NivelEscuela> getNivelesEscuela(String escuelaId, String sort);

    Mono<NivelEscuela> deleteNivelEscuela(Long id);
}
