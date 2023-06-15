package com.codurance;

import com.codurance.core.CarConfigUser;
import com.codurance.jaguar.JaguarConfigurationBuilder;
import com.codurance.land_rover.LandRoverConfigurationBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CarConfigurationServiceTest {
    private static final CarConfigUser CONFIG_USER = new CarConfigUser("bob", "bob@example.org");
    private static final String CAR_CONFIG_ID = "2e9738ec-2d09-4332-b93d-bf6a182ce9a8";
    private static final String CAR_CONFIG_ID_LANDROVER = "2e9738ec-2d09-4332-b93d-bf6a182ce9a8";

    private static final CarConfiguration CAR_CONFIG = new CarConfiguration(CAR_CONFIG_ID, CONFIG_USER, JLRBrand.JAGUAR);
    private static final CarConfiguration CAR_CONFIG_LAND_ROVER = new CarConfiguration(CAR_CONFIG_ID_LANDROVER, CONFIG_USER, JLRBrand.LAND_ROVER);
    @Mock
    private CarConfigurationBuilder carConfigurationBuilder;
    @Mock
    ConfigurationRepository configurationRepository;
    @Mock
    private IdGenerator idGenerator;

    @Test
    void should_create_new_configuration_for_jaguar() {

        when(idGenerator.nextId()).thenReturn(CAR_CONFIG_ID);

        CarConfigurationService carConfigurationService = new CarConfigurationService(configurationRepository, idGenerator);

        var result = carConfigurationService.createNewConfig(CONFIG_USER, JLRBrand.JAGUAR);

        verify(configurationRepository).createConfig(CAR_CONFIG);
        assertEquals(CAR_CONFIG_ID, result);
    }

    @Test
    void should_create_new_configuration_for_landrover() {
        when(idGenerator.nextId()).thenReturn(CAR_CONFIG_ID);
        CarConfigurationService carConfigurationService = new CarConfigurationService(configurationRepository, idGenerator);

        var result = carConfigurationService.createNewConfig(CONFIG_USER, JLRBrand.LAND_ROVER);

        verify(configurationRepository).createConfig(CAR_CONFIG_LAND_ROVER);
        assertEquals(CAR_CONFIG_ID, result);
    }

    @Test
    void should_return_configuration_builder_for_given_config_id() {
        when(configurationRepository.getById(CAR_CONFIG_ID)).thenReturn(CAR_CONFIG);
        CarConfigurationService carConfigurationService = new CarConfigurationService(configurationRepository, idGenerator);

        var result = carConfigurationService.useConfig(CAR_CONFIG_ID);

        assertInstanceOf(JaguarConfigurationBuilder.class, result);
    }

    @Test
    void should_throw_exception_when_config_id_isnt_found() {
        when(configurationRepository.getById(CAR_CONFIG_ID)).thenThrow(CarConfigNotFoundException.class);
        var carConfigurationService = new CarConfigurationService(configurationRepository, idGenerator);
        assertThrows(CarConfigNotFoundException.class, () -> carConfigurationService.useConfig(CAR_CONFIG_ID));
    }

    @Test
    void should_return_configuration_for_given_config_id() {
        when(configurationRepository.getById(CAR_CONFIG_ID)).thenReturn(CAR_CONFIG);
        var carConfigurationService = new CarConfigurationService(configurationRepository, idGenerator);
        var result = carConfigurationService.getById(CAR_CONFIG_ID);
        assertEquals(CAR_CONFIG, result);
    }

    @Test
    void should_return_configuration_builder_for_land_rover() {
        when(configurationRepository.getById(CAR_CONFIG_ID_LANDROVER)).thenReturn(CAR_CONFIG_LAND_ROVER);
        var carConfigurationService = new CarConfigurationService(configurationRepository, idGenerator);
        var result = carConfigurationService.useConfig(CAR_CONFIG_ID);
        assertInstanceOf(LandRoverConfigurationBuilder.class, result);
    }
}

