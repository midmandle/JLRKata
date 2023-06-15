package com.codurance.core;

import com.codurance.IdGenerator;

import java.util.UUID;

public class UuidIdGenerator implements IdGenerator {
    @Override
    public String nextId() {
        return UUID.randomUUID().toString();
    }
}
