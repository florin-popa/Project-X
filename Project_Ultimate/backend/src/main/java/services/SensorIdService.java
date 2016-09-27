package services;

import entities.Environmental;
import entities.SensorId;
import implementations.interfaces.BaseRepository;
import interfaces.services.ISensorIdService;

import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 26.09.2016.
 */
public class SensorIdService implements ISensorIdService<SensorId> {

    private BaseRepository<SensorId> sensorId;

    public void storeEntity(SensorId sensor) {
        sensorId.storeEntity(sensor);
    }

    public SensorId retrieveEntity(int key) {
        return sensorId.retrieveEntity(key);
    }

    public void updateEntity(SensorId sensor) {
        sensorId.updateEntity(sensor);
    }

    public void removeEntity(int key) {
        sensorId.removeEntity(key);
    }

    public Collection getData() {
        return sensorId.getData();
    }

    public Collection getDataFromSensor(String sensor) {
        return sensorId.getDataFromSensor(sensor);
    }

    public int timeDifference(SensorId sensor) {
        return sensorId.timeDifference(sensor);
    }

    public List normalizeList(List list) {
        return sensorId.normalizeList(list);
    }

    public void setSensorId(BaseRepository<SensorId> sensorId) {
        this.sensorId = sensorId;
    }

}
