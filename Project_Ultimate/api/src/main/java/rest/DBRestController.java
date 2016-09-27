package rest;

import entities.Environmental;
import entities.Inertial;
import entities.SensorId;
import format.json.JSONDataFormatter;
import interfaces.services.*;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Controller
public class DBRestController {

    enum Sensor {
        Environmental, Inertial, Configuration
    }

    private IEnvironmentalService env;

    public IServiceInertial inertial;

    private IConfigurationService config;

    private IJsonService handler;

    private ISensorIdService sensorId;

    private ICSVParserService csvParse;

    @RequestMapping("/")
    public String setHomePage() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/upload", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus upload(@RequestBody String data) {
        String type = null;
        String[] result = null;
        JSONDataFormatter ds = new JSONDataFormatter();
        try {
            result = ds.convertToType(data);
        } catch (Exception e) {
            //log.error("ERROR! Invalid Json format!", e);
        }
        for (final String jsonRow : result) {
            try {
                JSONObject obj = new JSONObject(jsonRow);
                type = obj.getString("type");
            } catch (JSONException e) {
                //log.error("ERROR! The given Json does not have a type!", e);
                e.printStackTrace();
            }
            Sensor sensor = Sensor.valueOf(type);

            switch (sensor) {
                case Environmental:
                    try {
                        boolean marker = true;
                        Environmental environmentalToBeStored = handler.createEnvironmentalObject(jsonRow);
                        env.storeEntity(environmentalToBeStored);

                        if (sensorId.getData().size() == 0) {
                            sensorId.storeEntity(new SensorId(environmentalToBeStored.getId()));
                        } else {
                            Collection<SensorId> sensorIds = sensorId.getData();
                            Iterator it = sensorIds.iterator();
                            while (it.hasNext()) {
                                SensorId tempSensor = (SensorId) it.next();
                                if (environmentalToBeStored.getId().equals(tempSensor.getSensorId())) {
                                    marker = false;
                                }
                            }
                            if (marker) {
                                sensorId.storeEntity(new SensorId(environmentalToBeStored.getId()));
                            }
                        }
                    } catch (Exception e) {
                        //log.error("Failure sending data!", e);
                        e.printStackTrace();
                    }
                    break;
                case Inertial:
                    try {
                        Inertial inertialToBeStored = handler.createInertialObject(jsonRow);
                        inertial.storeEntity(inertialToBeStored);
                        boolean marker = true;

                        if (sensorId.getData().size() == 0) {
                            sensorId.storeEntity(new SensorId(inertialToBeStored.getId()));
                        } else {
                            Collection<SensorId> sensorIds = sensorId.getData();
                            Iterator it = sensorIds.iterator();
                            while (it.hasNext()) {
                                SensorId tempSensor = (SensorId) it.next();
                                if (inertialToBeStored.getId().equals(tempSensor.getSensorId())) {
                                    marker = false;
                                }
                            }
                            if (marker) {
                                sensorId.storeEntity(new SensorId(inertialToBeStored.getId()));
                            }
                        }
                    } catch (Exception e) {
                        //log.error("Failure sending data!", e);
                        e.printStackTrace();
                    }
                    break;
                case Configuration:
                    try {
                        config.storeEntity(handler.createConfigurationObject(jsonRow));
                    } catch (Exception e) {
                        //log.error("Failure sending data!", e);
                        e.printStackTrace();
                    }
                    break;
                default:
                    System.out.println("sasasa");
            }
        }
        return HttpStatus.OK;
    }

    @Autowired
    public void setSensorId(ISensorIdService sensorId) {
        this.sensorId = sensorId;
    }

    @Autowired
    public void setCsvParse(ICSVParserService csvParse) {
        this.csvParse = csvParse;
    }

    @Autowired
    public void setEnv(IEnvironmentalService env) {
        this.env = env;
    }

    @Autowired
    public void setInertial(IServiceInertial inertial) {
        this.inertial = inertial;
    }

    @Autowired
    public void setConfig(IConfigurationService config) {
        this.config = config;
    }

    @Autowired
    public void setHandler(IJsonService handler) {
        this.handler = handler;
    }

}

