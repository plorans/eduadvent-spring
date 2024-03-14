package edu.um.eduadventspring.Manager;

import edu.um.eduadventspring.Model.Escuela;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface EscuelaManager {

    Character getEstadoEscuela(String escuelaId);

    String getNombre(String escuela);

    Mono<Escuela> saveEscuela(Escuela escuela);

    Mono<Escuela> removeEscuela(Long id);

    Mono<Escuela> getEscuela(String escuelaId);

    Flux<Escuela> getEscuelas();
}
