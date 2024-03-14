package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.NivelDao;
import edu.um.eduadventspring.Manager.NivelManager;
import edu.um.eduadventspring.Model.Nivel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("NivelManager")
public class NivelManagerImpl implements NivelManager {

    @Autowired
    private NivelDao nivelDao;

    @Autowired
    private EntityManagerFactory entityManagerFactory;
    
    @Override
    @Transactional
    public Mono<Nivel> saveNivel(Nivel nivel) {
        return Mono.fromCallable(() -> {
            try (EntityManager em = entityManagerFactory.createEntityManager()) {
                EntityTransaction transaction = em.getTransaction();
                try {
                    transaction.begin();
                    em.persist(nivel);
                    transaction.commit();
                    return nivel;
                } catch (Exception e) {
                    transaction.rollback();
                    throw e;
                }
            }
        });
    }

    @Override
    public Mono<Nivel> getNivel(Long id) {
        return Mono.fromSupplier(() -> nivelDao.findById(id).orElse(null));
    }

    @Override
    public Flux<Nivel> getNiveles() {
        return Flux.fromIterable(nivelDao.findAll());
    }

    @Override
    @Transactional
    public Mono<Nivel> deleteNivel(Long id) {
        return Mono.fromCallable(() -> {
            Nivel nivel;
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                nivel = em.find(Nivel.class, id);
                if (nivel != null) {
                    em.remove(nivel);
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
            return nivel;
        });
    }

}
