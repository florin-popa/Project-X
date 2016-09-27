package rest;

import entities.Environmental;
import entities.Inertial;
import entities.SensorId;
import interfaces.services.IEnvironmentalService;
import interfaces.services.ISensorIdService;
import interfaces.services.IServiceInertial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class UIController {

    public IServiceInertial inertial;
    public IEnvironmentalService environmental;
    private ISensorIdService sensorIdUtils;

    @ResponseBody
    @RequestMapping(value = "/inertials", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Inertial> inertials() {
        Collection<Inertial> inertials = inertial.getData();
        return inertials;
    }

    @ResponseBody
    @RequestMapping(value = "/environmentals", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Environmental> environmentals() {
        Collection<Environmental> environmentals = environmental.getData();
        return environmentals;
    }

    @ResponseBody
    @RequestMapping(value = "/environmentalsbyid", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Environmental> getEnvironmentalsById(String id) {
        Collection<Environmental> environmentals = environmental.getDataFromSensor(id);
        return environmentals;
    }

    @ResponseBody
    @RequestMapping(value = "/inertialsbyid", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Inertial> getInertialsById(String id) {
        Collection<Inertial> inertials = inertial.getDataFromSensor(id);
        return inertials;
    }

    @ResponseBody
    @RequestMapping(value = "/sensorids", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<SensorId> getSensorIds() {
        Collection<SensorId> sensorIds = sensorIdUtils.getData();
        return sensorIds;
    }

    @Autowired
    public void setSensorIdUtils(ISensorIdService sensorIdUtils) {
        this.sensorIdUtils = sensorIdUtils;
    }

    @Autowired
    public void setInertial(IServiceInertial inertial) {
        this.inertial = inertial;
    }

    @Autowired
    public void setEnvironmental(IEnvironmentalService environmental) {
        this.environmental = environmental;
    }
}
