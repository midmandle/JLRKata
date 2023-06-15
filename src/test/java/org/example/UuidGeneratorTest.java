package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UuidGeneratorTest {
    @Test
    void generate_uuid() {
        var uuidGenerator = new UuidIdGenerator();
        var result = uuidGenerator.nextId();
        assertNotNull(result);
    }
}
