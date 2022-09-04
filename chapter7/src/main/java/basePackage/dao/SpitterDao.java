package basePackage.dao;

import basePackage.model.Spitter;
import org.hibernate.Session;

public interface SpitterDao {

    void saveSpitter(Spitter spitter);

    void updateSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    default Session currentSession(){
        return null;
    }
}
