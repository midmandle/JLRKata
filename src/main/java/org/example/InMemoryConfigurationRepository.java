package org.example;

public class InMemoryConfigurationRepository implements ConfigurationRepository {
    @Override
    public void createConfig(CarConfiguration carConfig) {
        throw new UnsupportedOperationException();
    }

    @Override
    public CarConfiguration getById(String carConfigId) {
        throw new UnsupportedOperationException();
    }
}
