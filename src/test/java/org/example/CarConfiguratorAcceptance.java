package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CarConfiguratorAcceptance {
    @Test
    void bill_makes_a_car_and_summarizes_it() {
        // Bill wants to configure a car
        String expected = "Land Rover Sport V8 4.0L Red";
        var configuration = new CarConfiguration();
        CarConfigurationService configurationService = new CarConfigurationService();
        // Bill Selects the brand as Land Rover
        // Bill Selects the engine as V8 4.0L
        // Bill Selects the colour is Red
        String actual = configuration.summarize();
        assertEquals(expected, actual);
    }
}
