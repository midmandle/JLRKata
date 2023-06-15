package com.codurance.unit.infrastructure;

import com.codurance.CarConfigNotFoundException;
import com.codurance.core.CarConfigUser;
import com.codurance.CarConfiguration;
import com.codurance.JLRBrand;
import com.codurance.infrastructure.InMemoryConfigurationRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class InMemoryConfigurationRepositoryTest {
    private static final CarConfigUser CONFIG_USER = new CarConfigUser("bob", "bob@domain.com");
    private static final String CONFIG_ID = "2e9738ec-2d09-4332-b93d-bf6a182ce9a8";

    @Test
    void create_config() {
        var configRepository = new InMemoryConfigurationRepository();
        var config = new CarConfiguration(CONFIG_ID, CONFIG_USER, JLRBrand.LAND_ROVER);
        configRepository.createConfig(config);
        var result = configRepository.getById(CONFIG_ID);

        assertEquals(config, result);
    }

    @Test
    void throw_exception_when_config_with_id_doesnt_exist() {
        var configRepository = new InMemoryConfigurationRepository();
        assertThrows(CarConfigNotFoundException.class, () -> configRepository.getById(CONFIG_ID));
    }
}
