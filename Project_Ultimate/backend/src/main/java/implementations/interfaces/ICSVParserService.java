package implementations.interfaces;

import entities.Environmental;
import entities.Inertial;

import java.util.Collection;

/**
 * Created by POF4CLJ on 23.08.2016.
 */
public interface ICSVParserService {

    public String csvInertialParser(Collection<Inertial> inertials);

    public String csvEnvironmentalParser(Collection<Environmental> environmentals);

}
