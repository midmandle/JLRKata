package org.example;

import java.lang.module.Configuration;

public interface CarConfigurator {
    String summarize();

    CarModel selectModel(String model);
}
