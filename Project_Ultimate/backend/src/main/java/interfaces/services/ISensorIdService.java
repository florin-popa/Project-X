package interfaces.services;

import com.fasterxml.jackson.databind.deser.Deserializers;
import entities.BaseEntity;
import entities.Environmental;
import entities.SensorId;

import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 26.09.2016.
 */
public interface ISensorIdService <ENTITY extends BaseEntity> {

    public void storeEntity(SensorId sensorId);

    public SensorId retrieveEntity(int key);

    public void updateEntity(SensorId sensorId);

    public void removeEntity(int key);

    public Collection<SensorId> getData();

    public Collection<SensorId> getDataFromSensor(String sensorId);

    public int timeDifference(SensorId sensorId);

    public abstract List<SensorId> normalizeList(List<SensorId> list);

}
