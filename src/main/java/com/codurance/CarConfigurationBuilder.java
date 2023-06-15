package com.codurance;

public interface CarConfigurationBuilder {
    String summarize();

    CarModel selectModel(String model);
}
