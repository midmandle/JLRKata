package org.example;

public enum LandRoverModelList {
    EVOQUE ("Evoque"), SPORT ("Sport");

    private final String name;

    LandRoverModelList(String name) {

        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
