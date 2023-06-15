package com.codurance.acceptance;

import com.codurance.*;
import com.codurance.core.CarConfigUser;
import com.codurance.core.JLRBrand;
import com.codurance.core.JLRColours;
import com.codurance.core.UuidIdGenerator;
import com.codurance.infrastructure.InMemoryConfigurationRepository;
import com.codurance.jaguar.JaguarConfigurationBuilder;
import com.codurance.jaguar.JaguarEngineList;
import com.codurance.jaguar.JaguarModelList;
import com.codurance.land_rover.LandRoverConfigurationBuilder;
import com.codurance.land_rover.LandRoverEngineList;
import com.codurance.land_rover.LandRoverModelList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarConfiguratorAcceptance {
    @Test
    void make_a_jaguar() {
        String expected = "Jaguar XJ V10 2.0l Black";
        CarConfigurationBuilder configurator = new JaguarConfigurationBuilder();

        configurator.selectModel(String.valueOf(JaguarModelList.XJ))
                .selectEngine(String.valueOf(JaguarEngineList.V10_2L))
                .selectColour(String.valueOf(JLRColours.BLACK));

        String actual = configurator.summarize();

        assertEquals(expected, actual);
    }

    @Test
    void make_a_land_rover() {
        String expected = "Land Rover Sport V8 4.0l Red";
        CarConfigurationBuilder configurator = new LandRoverConfigurationBuilder();

        configurator.selectModel(String.valueOf(LandRoverModelList.SPORT))
                .selectEngine(String.valueOf(LandRoverEngineList.V8_4L))
                .selectColour(String.valueOf(JLRColours.RED));

        String actual = configurator.summarize();

        assertEquals(expected, actual);
    }

    @Test
    void a_user_makes_a_car_and_summarizes_it() {
        String expected = "Land Rover Sport V8 4.0L Red";
        var carBrand = JLRBrand.LAND_ROVER;
        var carConfigRepository = new InMemoryConfigurationRepository();
        var idGenerator = new UuidIdGenerator();
        var configurationService = new CarConfigurationService(carConfigRepository, idGenerator);
        var user = new CarConfigUser("bob", "bob@example.com");
        var configId = configurationService.createNewConfig(user, carBrand);

        var carModel = configurationService.useConfig(configId)
                .selectModel(LandRoverModelList.SPORT.toString())
                .selectEngine(LandRoverEngineList.V8_4L.toString())
                .selectColour(JLRColours.BLUE.toString())
        ;

        var configuration = configurationService.getById(configId);
        //TODO: we have to save CarModel explicitly
        var actual = configuration.summarize();
        assertEquals(expected, actual);
    }
}
