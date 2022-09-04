package basePackage.dao;

import basePackage.model.Spitter;
import org.hibernate.Session;

public interface SpitterDao {

    void addSpitter(Spitter spitter);

    void saveSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    default Session currentSession(){
        return null;
    }
}
