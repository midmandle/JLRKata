package org.example;

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
        CarConfigurationBuilder configurator = new LandRoverConfigurator();

        configurator.selectModel(String.valueOf(LandRoverModelList.SPORT))
                .selectEngine(String.valueOf(LandRoverEngineList.V8_4L))
                .selectColour(String.valueOf(JLRColours.RED));

        String actual = configurator.summarize();

        assertEquals(expected, actual);
    }

    @Test
    void a_user_makes_a_car_and_summarizes_it() {
        String expected = "Land Rover Sport V8 4.0l Red";
        var carBrand = JLRBrand.LAND_ROVER;
        var carConfigRepository = new InMemoryConfigurationRepository();
        CarConfigurationService configurationService = new CarConfigurationService(carConfigRepository);
        CarConfigUser user = new CarConfigUser("bob", "bob@example.com");
        String configId = configurationService.createNewConfig(user, carBrand);

        configurationService.selectConfig(configId)
                .selectModel(LandRoverModelList.SPORT.toString())
                .selectEngine(LandRoverEngineList.V8_4L.toString())
                .selectColour(JLRColours.BLUE.toString());

        CarConfiguration configuration = configurationService.getById(configId);
        String actual = configuration.summarize();
        assertEquals(expected, actual);
    }
}
