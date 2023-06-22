package ru.netology.test.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;
import ru.netology.sender.MessageSenderImpl;

import java.util.HashMap;

public class SendsAndReturnTextTest {
    @Test
    void sendsText() {

        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        MessageSenderImpl messageSender = new MessageSenderImpl(geoService, localizationService);

        HashMap mapRu = new HashMap();
        mapRu.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.0.0.0");

        HashMap mapENG = new HashMap();
        mapENG.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.0.0.0");

        String expectedENG = "Welcome ";
        String expectedRu = "Добро пожаловать ";

        String preferencesENG = messageSender.send(mapENG);
        String preferencesRu = messageSender.send(mapRu);

        Assertions.assertEquals(expectedRu, preferencesRu);
        Assertions.assertEquals(expectedENG, preferencesENG);

    }
    @Test
    void checkingTheReturnedText() {
        String expected = "Добро пожаловать ";
        String preferences = new LocalizationServiceImpl().locale(Country.RUSSIA);

        Assertions.assertEquals(expected, preferences);
    }
}
