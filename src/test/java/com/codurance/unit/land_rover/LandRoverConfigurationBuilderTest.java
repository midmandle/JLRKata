package com.codurance.unit.land_rover;

import com.codurance.CarConfigurationBuilder;
import com.codurance.CarModel;
import com.codurance.core.JLRColours;
import com.codurance.land_rover.LandRoverConfigurationBuilder;
import com.codurance.land_rover.LandRoverEngineList;
import com.codurance.land_rover.LandRoverModel;
import com.codurance.land_rover.LandRoverModelList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandRoverConfigurationBuilderTest {

    @Test
    void selectSportModel() {
        CarConfigurationBuilder landRoverConfigurator = new LandRoverConfigurationBuilder();

        CarModel actual = landRoverConfigurator.selectModel(String.valueOf(LandRoverModelList.SPORT));

        CarModel expected = new LandRoverModel(LandRoverModelList.SPORT);
        assertEquals(expected, actual);
    }

    @Test
    void selectEvoqueModel() {
        CarConfigurationBuilder landRoverConfigurator = new LandRoverConfigurationBuilder();

        CarModel actual = landRoverConfigurator.selectModel(String.valueOf(LandRoverModelList.EVOQUE));

        CarModel expected = new LandRoverModel(LandRoverModelList.EVOQUE);
        assertEquals(expected, actual);
    }

    @Test
    void summarizeConfigurationForLandRoverSportV84LRed() {
        CarModel model = new LandRoverModel(LandRoverModelList.SPORT, LandRoverEngineList.V8_4L, JLRColours.RED);
        CarConfigurationBuilder landRoverConfigurator = new LandRoverConfigurationBuilder(model);

        String actual = landRoverConfigurator.summarize();

        String expected = "Land Rover Sport V8 4.0L Red";
        assertEquals(expected, actual);
    }
}