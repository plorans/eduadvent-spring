package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.Nivel;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NivelManager {
    
    Mono<Nivel> saveNivel(Nivel nivel);

    Mono<Nivel> getNivel(Long id);

    Flux<Nivel> getNiveles();

    Mono<Nivel> deleteNivel(Long id);
}
