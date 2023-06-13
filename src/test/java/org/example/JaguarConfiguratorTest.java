package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JaguarConfiguratorTest {

    @Test
    void selectXJModel() {
        CarConfigurator jaguarConfigurator = new JaguarConfigurator();

        CarModel actual = jaguarConfigurator.selectModel(String.valueOf(JaguarModelList.XJ));

        CarModel expected = new JaguarModel(JaguarModelList.XJ);
        assertEquals(expected, actual);
    }

    @Test
    void selectXFModel() {
        CarConfigurator jaguarConfigurator = new JaguarConfigurator();

        CarModel actual = jaguarConfigurator.selectModel(String.valueOf(JaguarModelList.XF));

        CarModel expected = new JaguarModel(JaguarModelList.XF);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeConfigurationForJaguarXJV102LBlack() {
        CarModel model = new JaguarModel(JaguarModelList.XJ, JaguarEngineList.V10_2L, JLRColours.BLACK);
        CarConfigurator jaguarConfigurator = new JaguarConfigurator(model);

        String actual = jaguarConfigurator.summarize();

        String expected = "Jaguar XJ V10 2.0l Black";
        assertEquals(expected, actual);
    }
}