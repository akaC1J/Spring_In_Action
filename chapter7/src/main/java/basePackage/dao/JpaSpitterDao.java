package basePackage.dao;

import basePackage.model.Spitter;
import basePackage.model.Spittle;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaSpitterDao implements SpitterDao {
    private static final String RECENT_SPITTLES =
            "SELECT s FROM Spittle s";
    private static final String ALL_SPITTERS =
            "SELECT s FROM Spitter s";
    private static final String SPITTER_FOR_USERNAME =
            "SELECT s FROM Spitter s WHERE s.username = :username";
    private static final String SPITTLES_BY_USERNAME =
            "SELECT s FROM Spittle s WHERE s.spitter.username = :username";

    @PersistenceContext(unitName = "entityManagerFactory")
    private EntityManager em; //<co id="co_injectEM"/>
    @Override
    public void saveSpitter(Spitter spitter) {
        em.persist(spitter); //<co id="co_useEM"/>
    }

    public void updateSpitter(Spitter spitter) {
        em.merge(spitter); //<co id="co_useEM"/>
    }

    @Override
    public Spitter getSpitterById(long id) {
        return em.find(Spitter.class, id);
    }

    //<end id="java_contextualJpaDao"/>
    @SuppressWarnings("unchecked")
    public List<Spittle> getRecentSpittle() {
        return (List<Spittle>) em.createQuery(RECENT_SPITTLES).
                getResultList();
    }

    public void saveSpittle(Spittle spittle) {
        em.persist(spittle);
    }

    @SuppressWarnings("unchecked")
    public List<Spittle> getSpittlesForSpitter(
            Spitter spitter) {
        return (List<Spittle>) em.createQuery(SPITTLES_BY_USERNAME).
                setParameter("username", spitter.getUsername()).
                getResultList();
    }


    public Spitter getSpitterByUsername(String username) {
        return (Spitter) em.createQuery(SPITTER_FOR_USERNAME).
                setParameter("username", username).
                getSingleResult();
    }

    public void deleteSpittle(long id) {
        try {
            em.remove(getSpittleById(id));
        } catch (DataAccessException ignored) {
        }
    }

    public Spittle getSpittleById(long id) {
        return em.find(Spittle.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Spitter> findAllSpitters() {
        return em.createQuery(ALL_SPITTERS).getResultList();
    }
}
