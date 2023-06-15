package com.codurance.unit.jaguar;

import com.codurance.CarConfigurationBuilder;
import com.codurance.CarModel;
import com.codurance.core.JLRColours;
import com.codurance.jaguar.JaguarConfigurationBuilder;
import com.codurance.jaguar.JaguarEngineList;
import com.codurance.jaguar.JaguarModel;
import com.codurance.jaguar.JaguarModelList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JaguarConfiguratorTest {

    @Test
    void selectXJModel() {
        CarConfigurationBuilder jaguarConfigurator = new JaguarConfigurationBuilder();

        CarModel actual = jaguarConfigurator.selectModel(String.valueOf(JaguarModelList.XJ));

        CarModel expected = new JaguarModel(JaguarModelList.XJ);
        assertEquals(expected, actual);
    }

    @Test
    void selectXFModel() {
        CarConfigurationBuilder jaguarConfigurator = new JaguarConfigurationBuilder();

        CarModel actual = jaguarConfigurator.selectModel(String.valueOf(JaguarModelList.XF));

        CarModel expected = new JaguarModel(JaguarModelList.XF);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeConfigurationForJaguarXJI42LBlack() {
        CarModel model = new JaguarModel(JaguarModelList.XJ, JaguarEngineList.I4_2L, JLRColours.BLACK);
        CarConfigurationBuilder jaguarConfigurator = new JaguarConfigurationBuilder(model);

        String actual = jaguarConfigurator.summarize();

        String expected = "Jaguar XJ I4 2.0L Black";
        assertEquals(expected, actual);
    }
}