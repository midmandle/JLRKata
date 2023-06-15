package com.codurance;

import com.codurance.core.CarConfiguration;

public interface ConfigurationRepository {
    void createConfig(CarConfiguration carConfig);

    CarConfiguration getById(String carConfigId);
}
