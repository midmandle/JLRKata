package com.codurance.land_rover;

import com.codurance.CarConfigurationBuilder;
import com.codurance.CarModel;
import com.codurance.CarEngine;

public class LandRoverConfigurationBuilder implements CarConfigurationBuilder {
    private CarModel model = null;
    private CarEngine engine = null;

    public LandRoverConfigurationBuilder(CarModel model) {
        this.model = model;
    }

    public LandRoverConfigurationBuilder() {
    }

    @Override
    public CarModel selectModel(String model) {
        this.model = new LandRoverModel(LandRoverModelList.SPORT);
        if (model.equals(String.valueOf(LandRoverModelList.EVOQUE))) {
            this.model = new LandRoverModel(LandRoverModelList.EVOQUE);
        }

        return this.model;
    }

    @Override
    public String summarize() {
        String brandName = "Land Rover";
        String modelSummary = model.summarize();
        return "%s %s".formatted(brandName, modelSummary);
    }
}
