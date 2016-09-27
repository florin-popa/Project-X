package implementations;

import entities.Environmental;
import entities.Inertial;
import implementations.interfaces.BaseRepository;

import javax.persistence.Query;
import java.util.*;

/**
 * Created by POF4CLJ on 27.07.2016.
 */
public class EnviromentalRepository extends BaseRepository<Environmental> {
    public void storeEntity(Environmental env) {

        em.getTransaction().begin();
        em.persist(env);
        em.getTransaction().commit();
    }

    public Environmental retrieveEntity(int key) {
        return em.find(Environmental.class, key);
    }

    public void updateEntity(Environmental env) {
        em.merge(env);
        em.getTransaction().commit();
    }

    public void removeEntity(int key) {
        em.getTransaction().begin();
        em.remove(em.find(Environmental.class, key));
        em.getTransaction().commit();
    }

    public Collection<Environmental> getData() {
        return (Collection<Environmental>) em.createQuery("SELECT c FROM Environmental c").getResultList();
    }

    public Collection<Environmental> getDataFromSensor(String sensorId) {
        return (Collection<Environmental>) em.createQuery("SELECT c FROM Environmental c WHERE c.id = '"+sensorId+"'").getResultList();
    }

    public int timeDifference(Environmental e) {
        Date now = Calendar.getInstance().getTime();
        long difMil = now.getTime() - e.getTime().getTime();
        long difHour = (difMil) / 1000L / 60L / 60L;
        return (int) difHour;
    }

    public List<Environmental> normalizeList(List<Environmental> list) {
        List<Environmental> data = new ArrayList<Environmental>();
        int nrOfEl = 20;
        int size = list.size();
        int merge = size / nrOfEl;
        int date;
        int j = 0;
        for (int i = 0; i < nrOfEl; i++) {
            int t = 0;
            int rhw = 0;
            int p = 0;
            int l = 0;
            for (j = 0; j < merge; j++) {
                t += list.get(i * merge + j).getT();
                rhw += list.get(i * merge + j).getRhw();
                p += list.get(i * merge + j).getP();
                l += list.get(i * merge + j).getL();
            }
            Environmental e = new Environmental();
            e.setT(t / merge);
            e.setRhw(rhw / merge);
            e.setP(p / merge);
            e.setL(l / merge);
            e.setTime(list.get(i * merge + j).getTime());
            e.setGw_id(list.get(i * merge + j).getGw_id());
            e.setId(list.get(i * merge + j).getId());
            data.add(e);
        }
        return data;
    }
}
