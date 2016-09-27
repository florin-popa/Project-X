package implementations;

import entities.BaseEntity;
import entities.Environmental;
import entities.SensorId;
import implementations.interfaces.BaseRepository;

import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 26.09.2016.
 */
public class SensorIdRepository extends BaseRepository<SensorId> {


    public void storeEntity(SensorId sensor) {
        em.getTransaction().begin();
        em.persist(sensor);
        em.getTransaction().commit();
    }

    public SensorId retrieveEntity(int key) {
        return null;
    }

    public void updateEntity(SensorId sensorId) {

    }

    public void removeEntity(int key) {

    }

    public Collection getData() {
        return (Collection<Environmental>) em.createQuery("SELECT c FROM SensorId c").getResultList();
    }

    public Collection getDataFromSensor(String sensorId) {
        return null;
    }

    public int timeDifference(SensorId sensorId) {
        return 0;
    }

    public List normalizeList(List list) {
        return null;
    }
}
