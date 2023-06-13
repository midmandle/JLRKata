package org.example;

public interface CarModel {
    CarModel selectEngine(String engine);
    CarModel selectColour(String colour);

    String summarize();
}
