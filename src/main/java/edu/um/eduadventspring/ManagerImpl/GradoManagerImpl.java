package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EscuelaDao;
import edu.um.eduadventspring.Dao.GradoDao;
import edu.um.eduadventspring.Dao.NivelDao;
import edu.um.eduadventspring.Manager.GradoManager;
import edu.um.eduadventspring.Model.Escuela;
import edu.um.eduadventspring.Model.Grado;
import edu.um.eduadventspring.Model.Nivel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("GradoManager")
public class GradoManagerImpl implements GradoManager {

    @Autowired
    private NivelDao nivelDao;

    @Autowired
    private EscuelaDao escuelaDao;

    @Autowired
    private GradoDao gradoDao;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    @Transactional
    public Mono<Grado> saveGrado(Grado grado) {
        return Mono.fromCallable(() -> {
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            Nivel nivel = nivelDao.getReferenceById(grado.getNivelId());
            grado.setNivel(nivel);

            Escuela escuela = escuelaDao.findByEscuelaId(grado.getEscuelaId());
            grado.setEscuela(escuela);
            try {
                transaction.begin();
                Grado rGrado = em.merge(grado);
                em.persist(rGrado);
                transaction.commit();
                return rGrado;
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
    public Mono<Grado> getGrado(Long id) {
        return Mono.fromSupplier(() -> gradoDao.findById(id).orElse(null));
    }

    @Override
    public Flux<Grado> getGrados() {
        return Flux.fromIterable(gradoDao.findAll());
    }

    @Override
    @Transactional
    public Mono<Grado> deleteGrado(Long id) {
        return Mono.fromCallable(() -> {
            Grado grado;
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                grado = em.find(Grado.class, id);
                if (grado != null) {
                    em.remove(grado);
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
            return grado;
        });
    }
}