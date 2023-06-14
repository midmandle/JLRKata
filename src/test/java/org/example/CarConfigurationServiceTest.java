package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CarConfigurationServiceTest {
    private static final CarConfigUser CONFIG_USER = new CarConfigUser("bob", "bob@example.org");
    private static final String CAR_CONFIG_ID = "1-jaguar-config-id";
    private static final CarConfiguration CAR_CONFIG = new CarConfiguration(CAR_CONFIG_ID, CONFIG_USER, JLRBrand.JAGUAR);
    @Mock
    ConfigurationRepository configurationRepository;

    @Test
    void should_create_new_configuration_for_jaguar() {
        CarConfigurationService carConfigurationService = new CarConfigurationService(configurationRepository);
        var result = carConfigurationService.createNewConfig(CONFIG_USER, JLRBrand.JAGUAR);
        verify(configurationRepository).createConfig(CAR_CONFIG);
        assertEquals(CAR_CONFIG_ID, result);
    }
}

