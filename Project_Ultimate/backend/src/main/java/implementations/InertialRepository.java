package implementations;

import entities.Environmental;
import entities.Inertial;
import implementations.interfaces.BaseRepository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.text.DecimalFormat;
import java.util.*;

/**
 * Created by POF4CLJ on 29.07.2016.
 */
public class InertialRepository extends BaseRepository<Inertial> {
    public void storeEntity(Inertial entity) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
    }

    public Inertial retrieveEntity(int key) {
        Inertial entity = em.find(Inertial.class, key);
        return entity;
    }

    public void updateEntity(Inertial entity) {
        em.merge(entity);
        em.getTransaction().commit();
    }

    public void removeEntity(int key) {
        Inertial entity = em.find(Inertial.class, key);
        em.getTransaction().begin();
        em.remove(entity);
        em.getTransaction().commit();
    }

    public Collection<Inertial> getData() {
        List<Inertial> inertials = em.createQuery("SELECT i FROM Inertial i ORDER BY i.time").getResultList();
        return inertials;
    }

    public Collection<Inertial> getDataFromSensor(String sensorId) {
        return (Collection<Inertial>) em.createQuery("SELECT c FROM Inertial c WHERE c.id = '"+sensorId+"'").getResultList();
    }

    public int timeDifference(Inertial e) {
        Date now = Calendar.getInstance().getTime();
        long difMil = now.getTime() - e.getTime().getTime();
        long difHour = (difMil) / 1000L / 60L / 60L;
        return (int) difHour;
    }

    public List<Inertial> normalizeList(List<Inertial> list) {
        List<Inertial> l = new ArrayList<Inertial>();
        int nrOfEl=20;
        int size = list.size();
        int merge = size/nrOfEl;

        int date;
        int j=0;
        for(int i = 0;i<nrOfEl;i++){
            int ax=0;
            int ay=0;
            int az=0;
            int gx=0;
            int gy=0;
            int gz=0;
            int mx=0;
            int my=0;
            int mz=0;


            for (j = 0; j < merge; j++) {
                ax += list.get(i * merge + j).getAx();
                ay += list.get(i * merge + j).getAy();
                az += list.get(i * merge + j).getAz();
                gx += list.get(i * merge + j).getGx();
                gy += list.get(i * merge + j).getGy();
                gz += list.get(i * merge + j).getGz();
                mx += list.get(i * merge + j).getMx();
                my += list.get(i * merge + j).getMy();
                mz += list.get(i * merge + j).getMz();
            }
            Inertial e = new Inertial();
            e.setAx(ax / merge);
            e.setAz(az / merge);
            e.setAy(ay / merge);
            e.setMx(mx / merge);
            e.setMy(my / merge);
            e.setMz(mz / merge);
            e.setGx(gx / merge);
            e.setGy(gy / merge);
            e.setGz(gz / merge);
            e.setTime(list.get(i * merge + j).getTime());
            e.setGw_id(list.get(i * merge + j).getGw_id());
            e.setId(list.get(i * merge + j).getId());
            l.add(e);
       // }
        }
        return l;
    }
}
