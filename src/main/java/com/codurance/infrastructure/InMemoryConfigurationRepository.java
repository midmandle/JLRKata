package com.codurance.infrastructure;

import com.codurance.core.CarConfigNotFoundException;
import com.codurance.core.CarConfiguration;
import com.codurance.ConfigurationRepository;

import java.util.HashMap;

public class InMemoryConfigurationRepository implements ConfigurationRepository {
    private HashMap<String, CarConfiguration> configurations;

    public InMemoryConfigurationRepository() {
        this.configurations = new HashMap<>();
    }

    @Override
    public void createConfig(CarConfiguration carConfig) {
        configurations.put(carConfig.configId(), carConfig);
    }

    @Override
    public CarConfiguration getById(String carConfigId) {
        if (!configurations.containsKey(carConfigId)) {
            throw new CarConfigNotFoundException("No configuration with id " + carConfigId + " exists");
        }

        return configurations.get(carConfigId);
    }
}
