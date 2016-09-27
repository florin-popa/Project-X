package implementations;

import entities.Environmental;
import entities.Inertial;
import interfaces.services.ICSVParserUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

/**
 * Created by POF4CLJ on 23.08.2016.
 */
public class CSVParserUtils implements ICSVParserUtils {

    public String csvInertialParser(Collection<Inertial> inertials) {
        Iterator it = inertials.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String csv = "Categories,Ax,Ay,Az,Gx,Gy,Gz,Mx,My,Mz\n";

        while (it.hasNext()) {
            Inertial e = (Inertial) it.next();
            if (timeDifference(e) <= 700) {
                csv += sdf.format(e.getTime().getTime()) + ",";
                csv += e.getAx() + ",";
                csv += e.getAy() + ",";
                csv += e.getAz() + ",";
                csv += e.getGx() + ",";
                csv += e.getGy() + ",";
                csv += e.getGz() + ",";
                csv += e.getMx() + ",";
                csv += e.getMy() + ",";
                csv += e.getMz() + "\n";
            }
        }
        return csv;
    }

    public String csvEnvironmentalParser(Collection<Environmental> environmentals) {
        Iterator it = environmentals.iterator();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        String csv = "Categories,T,RHW,P,L,N\n";

        while (it.hasNext()) {
            Environmental e = (Environmental) it.next();
            if (timeDifference(e) <= 400) {
                csv += sdf.format(e.getTime().getTime()) + ",";
                csv += e.getT() + ",";
                csv += e.getRhw() + ",";
                csv += e.getP() + ",";
                csv += e.getL() + ",";
                csv += e.getN() + "\n";
            }
        }
        return csv;
    }

    private int timeDifference(Inertial e) {
        Date now = Calendar.getInstance().getTime();
        long difMil = now.getTime() - e.getTime().getTime();
        long difHour = (difMil) / 1000L / 60L / 60L;
        return (int) difHour;
    }

    private int timeDifference(Environmental e) {
        Date now = Calendar.getInstance().getTime();
        long difMil = now.getTime() - e.getTime().getTime();
        long difHour = (difMil) / 1000L / 60L / 60L;
        return (int) difHour;
    }

}
