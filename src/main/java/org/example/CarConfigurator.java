package org.example;

public interface CarConfigurator {
    String summarize();

    CarModel selectModel(String model);
}
