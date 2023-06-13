package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandRoverConfiguratorTest {

    @Test
    void selectSportModel() {
        CarConfigurator landRoverConfigurator = new LandRoverConfigurator();

        CarModel actual = landRoverConfigurator.selectModel(String.valueOf(LandRoverModelList.SPORT));

        CarModel expected = new LandRoverModel(LandRoverModelList.SPORT);
        assertEquals(expected, actual);
    }

    @Test
    void selectEvoqueModel() {
        CarConfigurator landRoverConfigurator = new LandRoverConfigurator();

        CarModel actual = landRoverConfigurator.selectModel(String.valueOf(LandRoverModelList.EVOQUE));

        CarModel expected = new LandRoverModel(LandRoverModelList.EVOQUE);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeConfigurationForLandRoverSportV84LRed() {
        CarModel model = new LandRoverModel(LandRoverModelList.SPORT, LandRoverEngineList.V8_4L, JLRColours.RED);
        CarConfigurator landRoverConfigurator = new LandRoverConfigurator(model);

        String actual = landRoverConfigurator.summarize();

        String expected = "Land Rover Sport V8 4.0l Red";
        assertEquals(expected, actual);
    }
}