package com.codurance.jaguar;

public enum JaguarEngineList {
    I4_2L("I4 2.0L"),
    V8_4L("V8 4.0L");

    private final String name;

    JaguarEngineList(String s) {
        name = s;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return this.name;
    }
}
