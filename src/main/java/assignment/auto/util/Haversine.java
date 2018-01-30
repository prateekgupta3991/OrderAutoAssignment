package assignment.auto.util;

import org.springframework.stereotype.Component;

@Component
public class Haversine {

    private static final int EARTH_RADIUS = 6371;

    public static Double distance(Double startLat, Double startLong, Double endLat, Double endLong) {

        Double dLat  = Math.toRadians((endLat - startLat));
        Double dLong = Math.toRadians((endLong - startLong));

        startLat = Math.toRadians(startLat);
        endLat   = Math.toRadians(endLat);

        Double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
        Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

        return EARTH_RADIUS * c;
    }

    public static Double haversin(Double val) {
        return Math.pow(Math.sin(val / 2), 2);
    }
}