package services;

import entities.Config;
import entities.Environmental;
import implementations.interfaces.BaseRepository;
import interfaces.services.IEnvironmentalService;

import java.util.Collection;
import java.util.List;

/**
 * Created by POF4CLJ on 28.07.2016.
 */
public class EnvironmentalService implements IEnvironmentalService<Environmental> {

    private BaseRepository<Environmental> entity;

    public void storeEntity(Environmental env) {
        entity.storeEntity(env);
    }

    public Environmental retrieveEntity(int key) {
        return entity.retrieveEntity(key);
    }

    public void updateEntity(Environmental env) {
        entity.updateEntity(env);
    }

    public void removeEntity(int key) {
        entity.removeEntity(key);
    }

    public BaseRepository<Environmental> getEntity() {
        return entity;
    }

    public Collection<Environmental> getData() {
        return entity.getData();
    }

    public Collection<Environmental> getDataFromSensor(String sensorId) {
        return entity.getDataFromSensor(sensorId);
    }

    public int timeDifference(Environmental e){
        return entity.timeDifference(e);
    }

    public List<Environmental> normalizeList(List<Environmental> list) {
        return entity.normalizeList(list);
    }

    public void setEntity(BaseRepository<Environmental> entity) {
        this.entity = entity;
    }
}
