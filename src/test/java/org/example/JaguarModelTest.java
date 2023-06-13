package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class JaguarModelTest {

    @Test
    void selectEngine() {
        JaguarModel jaguarModel = new JaguarModel();

        CarModel actual = jaguarModel.selectEngine(String.valueOf(JaguarEngineList.V10_2L));

        CarModel expected = new JaguarModel(JaguarEngineList.V10_2L);
        assertEquals(expected, actual);
    }

    @Test
    void selectColour() {
        JaguarModel jaguarModel = new JaguarModel();

        CarModel actual = jaguarModel.selectColour(String.valueOf(JLRColours.BLACK));

        CarModel expected = new JaguarModel(JLRColours.BLACK);
        assertEquals(expected, actual);
    }

    @Test
    void summarize() {
        JaguarModel jaguarModel = new JaguarModel(JaguarModelList.XF, JaguarEngineList.V8_4L, JLRColours.BLUE);

        String actual = jaguarModel.summarize();

        String expected = "XF V8 4.0l Blue";
        assertEquals(expected, actual);
    }
}