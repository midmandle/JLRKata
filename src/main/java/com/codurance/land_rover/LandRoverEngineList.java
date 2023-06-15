package com.codurance.land_rover;

public enum LandRoverEngineList {
    V6_3L("V6 3.0L"),
    V8_4L("V8 4.0L");

    private final String name;

    LandRoverEngineList(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
