package basePackage.dao;

import basePackage.model.Spitter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateSpitterDao implements SpitterDao{

    private SessionFactory sessionFactory;

    private Session session;

    public HibernateSpitterDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    // Извлекает текущий
    // сеанс из фабрики
    // SessionFactory
    public Session currentSession(){
        if (session == null) return session = sessionFactory.openSession();
        return session;

    }
    @Override
    public void addSpitter(Spitter spitter) {
        currentSession().persist(spitter);
    }

    @Override
    public void saveSpitter(Spitter spitter) {
        currentSession().merge(spitter);
    }

    @Override
    public Spitter getSpitterById(long id) {
        return currentSession().get(Spitter.class,id);
    }
}
