package com.codurance;

public enum JLRColours {
    RED ("Red"), BLUE ("Blue"), BLACK ("Black");

    private final String name;

    JLRColours(String colour) {
        this.name = colour;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
