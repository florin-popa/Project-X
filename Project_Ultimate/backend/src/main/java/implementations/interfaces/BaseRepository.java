package implementations.interfaces;

import entities.BaseEntity;
import entities.Environmental;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 27.07.2016.
 */
public abstract class BaseRepository<ENTITY extends BaseEntity> {

    protected EntityManagerFactory factory = Persistence.createEntityManagerFactory(getPersistentUnitName());

    protected EntityManager em = factory.createEntityManager();

    public abstract void storeEntity(ENTITY entity);

    public abstract ENTITY retrieveEntity(int key);

    public abstract void updateEntity(ENTITY entity);

    public abstract void removeEntity(int key);

    public abstract Collection<ENTITY> getData();

    public abstract Collection<ENTITY> getDataFromSensor(String sensorId);

    public abstract int timeDifference(ENTITY entity);

    public abstract List<ENTITY> normalizeList(List<ENTITY> list);

    protected String getPersistentUnitName() {
        return "mongo";
    }

}
