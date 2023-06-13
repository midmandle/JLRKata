package org.example;

import org.junit.jupiter.api.Test;

import java.lang.module.Configuration;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarConfiguratorAcceptance {
    @Test
    void make_a_jaguar() {
        String expected = "Jaguar XJ V10 2.0l Black";
        CarConfigurator configurator = new JaguarConfigurator();

        configurator.selectModel(String.valueOf(JaguarModelList.XJ))
                .selectEngine(String.valueOf(JaguarEngineList.V10_2L))
                .selectColour(String.valueOf(JLRColours.BLACK));

        String actual = configurator.summarize();

        assertEquals(expected, actual);
    }

    @Test
    void make_a_land_rover() {
        String expected = "Land Rover Sport V8 4.0l Red";
        CarConfigurator configurator = new LandRoverConfigurator();

        configurator.selectModel(String.valueOf(LandRoverModelList.SPORT))
                .selectEngine(String.valueOf(LandRoverEngineList.V8_4L))
                .selectColour(String.valueOf(JLRColours.RED));

        String actual = configurator.summarize();

        assertEquals(expected, actual);
    }


    @Test
    void a_user_makes_a_car_and_summarizes_it() {
        String expected = "Land Rover Sport V8 4.0l Red";

        CarConfigurator configurator = new LandRoverConfigurator();

        CarConfigUser user = new CarConfigUser();
        int configId = configurator.createNewConfig(user);

        configurator.selectConfig(configId)
                .selectModel(LandRoverModelList.SPORT.toString())
                .selectEngine(LandRoverEngineList.V8_4L.toString())
                .selectColour(JLRColours.BLUE.toString());

        CarConfiguration configuration = configurator.getById(configId);
        String actual = configuration.summarize();
        assertEquals(expected, actual);
    }

}
