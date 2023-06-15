package com.codurance.unit.core;

import com.codurance.core.UuidIdGenerator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UuidGeneratorTest {
    @Test
    void generate_uuid() {
        var uuidGenerator = new UuidIdGenerator();
        var result = uuidGenerator.nextId();
        assertNotNull(result);
    }
}
