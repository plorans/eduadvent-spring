package edu.um.eduadventspring.ManagerImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EscuelaDao;
import edu.um.eduadventspring.Manager.EscuelaManager;
import edu.um.eduadventspring.Model.Escuela;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("EscuelaManager")
public class EscuelaManagerImpl implements EscuelaManager {

    @Autowired
    private EscuelaDao escuelaDao;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Character getEstadoEscuela(String escuelaId) {
        Escuela salida = escuelaDao.findByEscuelaId(escuelaId);
        return salida.getEstado();
    }

    @Override
    public String getNombre(String escuelaId) {
        Escuela salida = escuelaDao.findByEscuelaId(escuelaId);
        return salida.getNombre();
    }

    @Override
    public Mono<Escuela> saveEscuela(Escuela escuela) {
        return Mono.fromCallable(() -> {
            try (EntityManager em = entityManagerFactory.createEntityManager()) {
                EntityTransaction transaction = em.getTransaction();
                try {
                    transaction.begin();
                    escuela.setEstado('A');
                    em.persist(escuela);
                    transaction.commit();
                    return escuela;
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        });
    }

    @Transactional
    @Override
    public Mono<Escuela> removeEscuela(Long id) {
        return Mono.fromCallable(() -> {
            Escuela escuela = null;
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                int updatedRows = escuelaDao.updateEstado('I', id);
                if (updatedRows > 0) {
                    escuela = em.find(Escuela.class, id);
                }
                transaction.commit();
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            } finally {
                em.close();
            }
            return escuela;
        });
    }

    @Override
    public Mono<Escuela> getEscuela(String esculaId) {
        return Mono.fromSupplier(() -> escuelaDao.findByEscuelaId(esculaId));
    }

    @Override
    public Flux<Escuela> getEscuelas() {
        return Flux.fromIterable(escuelaDao.findAll());
    }

    @Override
    public List<Escuela> getEscuelasByAsociacion(Long asociacionId) {
        return escuelaDao.findByAsociacionId_Id(asociacionId);
    }

}
