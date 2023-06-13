package org.example;

public enum LandRoverEngineList {
    V6_3L ("V6 3.0l"), V8_4L ("V8 4.0l");

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
