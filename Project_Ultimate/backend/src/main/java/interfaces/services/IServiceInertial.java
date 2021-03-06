package interfaces.services;

import com.fasterxml.jackson.databind.deser.Deserializers;
import entities.BaseEntity;
import entities.Config;
import entities.Environmental;
import entities.Inertial;

import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public interface IServiceInertial <ENTITY extends BaseEntity> {

    public void storeEntity(Inertial entity);

    public Inertial retrieveEntity(int key);

    public void updateEntity(Inertial entity);

    public void removeEntity(int key);

    public Collection<Inertial> getData();

    public Collection<Inertial> getDataFromSensor(String sensorId);

    public abstract List<ENTITY> normalizeList(List<ENTITY> list);

    public int timeDifference(Inertial e);


}
