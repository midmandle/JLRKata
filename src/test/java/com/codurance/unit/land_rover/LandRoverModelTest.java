package com.codurance.unit.land_rover;

import com.codurance.CarModel;
import com.codurance.core.JLRColours;
import com.codurance.land_rover.LandRoverEngineList;
import com.codurance.land_rover.LandRoverModel;
import com.codurance.land_rover.LandRoverModelList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LandRoverModelTest {

    @Test
    void selectEngine() {
        CarModel landRoverModel = new LandRoverModel();

        CarModel actual = landRoverModel.selectEngine(String.valueOf(LandRoverEngineList.V8_4L));

        CarModel expected = new LandRoverModel(LandRoverEngineList.V8_4L);
        assertEquals(expected, actual);
    }

    @Test
    void selectColour() {
        CarModel landRoverModel = new LandRoverModel();

        CarModel actual = landRoverModel.selectColour(String.valueOf(JLRColours.RED));

        CarModel expected = new LandRoverModel(JLRColours.RED);
        assertEquals(expected, actual);
    }

    @Test
    void summarize() {
        CarModel landRoverModel = new LandRoverModel(LandRoverModelList.EVOQUE, LandRoverEngineList.V6_3L, JLRColours.BLUE);

        String actual = landRoverModel.summarize();

        String expected = "Evoque V6 3.0l Blue";
        assertEquals(expected, actual);
    }
}