package services;

import entities.Environmental;
import entities.Inertial;
import interfaces.services.ICSVParserService;
import interfaces.services.ICSVParserUtils;

import java.util.Collection;

/**
 * Created by POF4CLJ on 23.08.2016.
 */
public class CSVParserService implements ICSVParserService {

    private ICSVParserUtils parser;

    public void setParser(ICSVParserUtils parser) {
        this.parser = parser;
    }

    public String csvInertialParser(Collection<Inertial> inertials) {
        return parser.csvInertialParser(inertials);
    }

    public String csvEnvironmentalParser(Collection<Environmental> environmentals) {
        return parser.csvEnvironmentalParser(environmentals);
    }
}
