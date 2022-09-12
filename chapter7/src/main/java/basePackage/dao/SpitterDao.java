package basePackage.dao;

import basePackage.model.Spitter;
import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public interface SpitterDao {

    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    void saveSpitter(Spitter spitter);


    void updateSpitter(Spitter spitter);

    Spitter getSpitterById(long id);

    default Session currentSession(){
        return null;
    }
}
