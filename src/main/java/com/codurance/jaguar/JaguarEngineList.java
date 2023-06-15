package com.codurance.jaguar;

public enum JaguarEngineList {
    V10_2L ("V10 2.0l"),
    V8_4L ("V8 4.0l");

    private final String name;

    private JaguarEngineList(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
