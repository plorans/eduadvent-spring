package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EscuelaDao;
import edu.um.eduadventspring.Dao.NivelDao;
import edu.um.eduadventspring.Dao.NivelEscuelaDao;
import edu.um.eduadventspring.Manager.NivelEscuelaManager;
import edu.um.eduadventspring.Model.Escuela;
import edu.um.eduadventspring.Model.Nivel;
import edu.um.eduadventspring.Model.NivelEscuela;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("NivelEscuelaManager")
public class NivelEscuelaManagerImpl implements NivelEscuelaManager {

    @Autowired
    private NivelDao nivelDao;

    @Autowired
    private EscuelaDao escuelaDao;

    @Autowired
    private NivelEscuelaDao nivelEscuelaDao;
    
    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    @Transactional
    public Mono<NivelEscuela> saveNivelEscuela(NivelEscuela nivelEscuela) {
        return Mono.fromCallable(() -> {
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            Nivel nivel = nivelDao.getReferenceById(nivelEscuela.getNivelId());
            nivelEscuela.setNivel(nivel);

            Escuela escuela = escuelaDao.findByEscuelaId(nivelEscuela.getEscuelaCodigo());
            nivelEscuela.setEscuela(escuela);
            try {
                transaction.begin();
                NivelEscuela rNivelEscuela = em.merge(nivelEscuela);
                em.persist(rNivelEscuela);
                transaction.commit();
                return rNivelEscuela;
            } catch (Exception e) {
                if (transaction.isActive()) {
                    transaction.rollback();
                }
                throw e;
            } finally {
                em.close();
            }
        });
    }

    @Override
    public Mono<NivelEscuela> getNivelEscuela(Long id) {
        return Mono.fromSupplier(() -> nivelEscuelaDao.findById(id).orElse(null));
    }

    @Override
    public Flux<NivelEscuela> getNivelesEscuela(String escuelaId, String sort) {
        Sort order = Sort.by(Sort.Direction.ASC, sort);
        return Flux.fromIterable(nivelEscuelaDao.findByEscuela_EscuelaId(escuelaId,order));
    }

    @Override
    @Transactional
    public Mono<NivelEscuela> deleteNivelEscuela(Long id) {
        return Mono.fromCallable(() -> {
            NivelEscuela nivelEscuela;
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                nivelEscuela = em.find(NivelEscuela.class, id);
                if (nivelEscuela != null) {
                    em.remove(nivelEscuela);
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
            return nivelEscuela;
        });
    }

}
