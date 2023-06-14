package org.example;

public class CarConfigurationService {
    private final ConfigurationRepository configurationRepository;

    public CarConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public CarConfigurationBuilder selectConfig(String configId) {
        throw new UnsupportedOperationException();
    }

    public String createNewConfig(CarConfigUser user, JLRBrand brand) {
        var id = "car-config-id";
        var carConfiguration = new CarConfiguration(id, user, brand);
        configurationRepository.createConfig(carConfiguration);
        return id;
    }

    public CarConfiguration getById(String configId) {
        throw new UnsupportedOperationException();
    }
}
