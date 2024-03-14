package edu.um.eduadventspring.ManagerImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import edu.um.eduadventspring.Dao.EscuelaDao;
import edu.um.eduadventspring.Dao.GradoDao;
import edu.um.eduadventspring.Dao.GrupoDao;
import edu.um.eduadventspring.Dao.NivelDao;
import edu.um.eduadventspring.Manager.GrupoManager;
import edu.um.eduadventspring.Model.Escuela;
import edu.um.eduadventspring.Model.Grado;
import edu.um.eduadventspring.Model.Grupo;
import edu.um.eduadventspring.Model.Nivel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.transaction.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service("GrupoManager")
public class GrupoManagerImpl implements GrupoManager {

    @Autowired
    private GrupoDao grupoDao;

    @Autowired
    private NivelDao nivelDao;

    @Autowired
    private EscuelaDao escuelaDao;

    @Autowired
    private GradoDao gradoDao;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public Mono<Grupo> getGrupo(Long id) {
        return Mono.fromSupplier(() -> grupoDao.findById(id).orElse(null));
    }

    @Override
    public Flux<Grupo> getGrupos() {
        return Flux.fromIterable(grupoDao.findAll());
    }

    @Override
    @Transactional
    public Mono<Grupo> saveGrupo(Grupo grupo) {
        return Mono.fromCallable(() -> {
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();

            Nivel nivel = nivelDao.getReferenceById(grupo.getNivelId());
            grupo.setNivel(nivel);

            Escuela escuela = escuelaDao.findByEscuelaId(grupo.getEscuelaId());
            grupo.setEscuela(escuela);

            Grado grado = gradoDao.getReferenceById(grupo.getGradoId());
            grupo.setGrado(grado);

            try {
                transaction.begin();
                Grupo rGrupo = em.merge(grupo);
                em.persist(rGrupo);
                transaction.commit();
                return rGrupo;
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
    public Mono<Grupo> deleteGrupo(Long id) {
        return Mono.fromCallable(() -> {
            Grupo grupo;
            EntityManager em = entityManagerFactory.createEntityManager();
            EntityTransaction transaction = em.getTransaction();
            try {
                transaction.begin();
                grupo = em.find(Grupo.class, id);
                if (grupo != null) {
                    em.remove(grupo);
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
            return grupo;
        });
    }

    @Override
    public Boolean existeNivel(String escuelaId, Long nivelId) {

        return grupoDao.existsByEscuela_EscuelaIdAndNivel_Id(escuelaId, nivelId);
    }

}
