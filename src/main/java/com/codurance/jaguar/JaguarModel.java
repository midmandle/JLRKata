package com.codurance.jaguar;

import com.codurance.CarModel;
import com.codurance.core.JLRColours;

import java.util.Objects;

public class JaguarModel implements CarModel {
    private JLRColours colour = null;
    private JaguarModelList model = null;
    private JaguarEngineList engine = null;

    public JaguarModel(JaguarEngineList engine) {
        this.engine = engine;
    }

    public JaguarModel(JaguarModelList model) {
        this.model = model;
    }

    public JaguarModel() {

    }

    public JaguarModel(JLRColours colour) {
        this.colour = colour;
    }

    public JaguarModel(JaguarModelList model, JaguarEngineList engine, JLRColours colour) {
        this.model = model;
        this.engine = engine;
        this.colour = colour;
    }

    @Override
    public CarModel selectEngine(String engine) {
        this.engine = JaguarEngineList.I4_2L;
        return this;
    }

    @Override
    public CarModel selectColour(String colour) {
        this.colour = JLRColours.BLACK;
        return this;
    }

    @Override
    public String summarize() {
        String modelName = model.name();
        String engineName = engine.toString();
        String vehicleColour = colour.toString();
        String modelDetails = engineName + " " + vehicleColour;
        return "%s %s".formatted(modelName, modelDetails);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JaguarModel that = (JaguarModel) o;
        return colour == that.colour && model == that.model && engine == that.engine;
    }

    @Override
    public int hashCode() {
        return Objects.hash(colour, model, engine);
    }
}
