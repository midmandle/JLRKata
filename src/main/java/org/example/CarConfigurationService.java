package org.example;

public class CarConfigurationService {
    private final ConfigurationRepository configurationRepository;
    private final IdGenerator idGenerator;

    public CarConfigurationService(ConfigurationRepository configurationRepository, IdGenerator idGenerator) {
        this.configurationRepository = configurationRepository;
        this.idGenerator = idGenerator;
    }

    public CarConfigurationBuilder useConfig(String configId) {
        var carConfig = configurationRepository.getById(configId);

        return new JaguarConfigurationBuilder();
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
