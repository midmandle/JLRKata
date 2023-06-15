package com.codurance.acceptance;

import com.codurance.CarConfigurationService;
import com.codurance.core.CarConfigUser;
import com.codurance.core.JLRBrand;
import com.codurance.core.JLRColours;
import com.codurance.core.UuidIdGenerator;
import com.codurance.infrastructure.InMemoryConfigurationRepository;
import com.codurance.land_rover.LandRoverEngineList;
import com.codurance.land_rover.LandRoverModelList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarConfiguratorAcceptance {
    @Test
    void a_user_makes_a_car_and_summarizes_it() {
        String expected = "Land Rover Sport V8 4.0L Red";
        var carBrand = JLRBrand.LAND_ROVER;
        var carConfigRepository = new InMemoryConfigurationRepository();
        var idGenerator = new UuidIdGenerator();
        var configurationService = new CarConfigurationService(carConfigRepository, idGenerator);
        var user = new CarConfigUser("bob", "bob@example.com");
        var configId = configurationService.createNewConfig(user, carBrand);

        // TODO: figure out if carmodel is trying to be a builder or not?
        var carModel = configurationService.useConfig(configId)
                .selectModel(LandRoverModelList.SPORT.toString())
                .selectEngine(LandRoverEngineList.V8_4L.toString())
                .selectColour(JLRColours.BLUE.toString());

        var configuration = configurationService.getById(configId);
        //TODO: we have to save CarModel explicitly
        var actual = configuration.summarize();
        assertEquals(expected, actual);
    }
}
