package services;
import entities.Environmental;
import entities.Inertial;
import entities.SensorId;
import implementations.EnviromentalRepository;
import implementations.InertialRepository;
import implementations.SensorIdRepository;

import java.util.Iterator;

/**
 * Created by POF4CLJ on 26.09.2016.
 */
public class Test {

    public static void main(String args[]){

        SensorIdRepository sen = new SensorIdRepository();
        sen.getData();
        EnviromentalRepository e = new EnviromentalRepository();
        InertialRepository i = new InertialRepository();
        Iterator iti = i.getDataFromSensor("460155e52e50").iterator();
        Iterator it = e.getDataFromSensor("460155e52e50").iterator();
        while(iti.hasNext()){
            Inertial env = (Inertial) iti.next();
            System.out.println(env.getId());
            System.out.println(env.getGw_id());
            System.out.println(env.getTime());
            System.out.println(env.getType());

        }

    }

}
