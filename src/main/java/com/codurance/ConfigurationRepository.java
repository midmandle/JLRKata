package com.codurance;

public interface ConfigurationRepository {
    void createConfig(CarConfiguration carConfig);

    CarConfiguration getById(String carConfigId);
}
