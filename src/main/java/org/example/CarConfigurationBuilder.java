package org.example;

public interface CarConfigurationBuilder {
    String summarize();
    CarModel selectModel(String model);
}
