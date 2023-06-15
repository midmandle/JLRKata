package com.codurance;

import com.codurance.core.CarConfigUser;
import com.codurance.core.CarConfiguration;
import com.codurance.core.JLRBrand;
import com.codurance.jaguar.JaguarConfigurationBuilder;
import com.codurance.land_rover.LandRoverConfigurationBuilder;

public class CarConfigurationService {
    private final ConfigurationRepository configurationRepository;
    private final IdGenerator idGenerator;

    public CarConfigurationService(ConfigurationRepository configurationRepository, IdGenerator idGenerator) {
        this.configurationRepository = configurationRepository;
        this.idGenerator = idGenerator;
    }

    public CarConfigurationBuilder useConfig(String configId) {
        var carConfig = configurationRepository.getById(configId);

        if (carConfig.brand() == JLRBrand.JAGUAR) {
            return new JaguarConfigurationBuilder();
        }

        return new LandRoverConfigurationBuilder();
    }

    public String createNewConfig(CarConfigUser user, JLRBrand brand) {
        var id = idGenerator.nextId();
        var carConfiguration = new CarConfiguration(id, user, brand);
        configurationRepository.createConfig(carConfiguration);
        return id;
    }

    public CarConfiguration getById(String configId) {
        return configurationRepository.getById(configId);
    }
}
