package org.example;

import java.util.Objects;

public class LandRoverModel implements CarModel {
    private JLRColours colour = null;
    private LandRoverEngineList engine = null;
    private LandRoverModelList model = null;

    public LandRoverModel(LandRoverModelList model) {
        this.model = model;
    }

    public LandRoverModel(LandRoverEngineList engine) {
        this.engine = engine;
    }

    public LandRoverModel(JLRColours colour) {
        this.colour = colour;
    }

    public LandRoverModel() {

    }

    public LandRoverModel(LandRoverModelList model, LandRoverEngineList engine, JLRColours colour) {
        this.model = model;
        this.engine = engine;
        this.colour = colour;
    }


    @Override
    public CarModel selectEngine(String engine) {
        this.engine = LandRoverEngineList.V8_4L;
        return this;
    }

    @Override
    public CarModel selectColour(String colour) {
        this.colour = JLRColours.RED;
        return this;
    }

    @Override
    public String summarize() {
        String modelName = model.toString();
        String engineDetails = engine.toString();
        String colourName = colour.toString();
        String modelDetails = engineDetails + " " + colourName;
        return "%s %s".formatted(modelName, modelDetails);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LandRoverModel that = (LandRoverModel) o;
        return colour == that.colour && engine == that.engine && model == that.model;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, engine, model);
    }
}
