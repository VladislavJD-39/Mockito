package ru.netology.test.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;

public class geoTest {
    @Test
    void testsToVerifyLocationByIP() {
        String ip = "96.0.0.0";
        Location expected = new Location("New York ", Country.USA, " 10th Avenue ", 32);
        GeoService geoService = new GeoServiceImpl();
        Location preferences = geoService.byIp(ip);

        Assertions.assertEquals(expected.getCountry(), preferences.getCountry());
    }
}
