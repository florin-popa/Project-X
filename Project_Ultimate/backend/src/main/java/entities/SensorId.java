package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by POF4CLJ on 26.09.2016.
 */
@Entity
public class SensorId extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int baseId;

    private String sensorId;

    public SensorId() {
    }

    public SensorId(String id) {
        this.sensorId = id;
    }

    public void setSensorId(String sensorId) {
        this.sensorId = sensorId;
    }

    public String getSensorId() {
        return sensorId;
    }
}
