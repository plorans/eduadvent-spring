package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.Grado;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GradoManager {

    Mono<Grado> saveGrado(Grado grado);

    Mono<Grado> getGrado(Long id);

    Flux<Grado> getGrados();

    Mono<Grado> deleteGrado(Long id);
}
