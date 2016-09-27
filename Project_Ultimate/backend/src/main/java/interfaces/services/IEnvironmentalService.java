package interfaces.services;

import entities.BaseEntity;
import entities.Config;
import entities.Environmental;

import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 28.07.2016.
 */
public interface IEnvironmentalService <ENTITY extends BaseEntity> {

    public void storeEntity(Environmental entity);

    public Environmental retrieveEntity(int key);

    public void updateEntity(Environmental entity);

    public void removeEntity(int key);

    public Collection<Environmental> getData();

    public Collection<Environmental> getDataFromSensor(String sensorId);

    public int timeDifference(Environmental e);

    public abstract List<Environmental> normalizeList(List<Environmental> list);


}
