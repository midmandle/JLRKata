package org.example;

import java.util.Objects;

public class CarConfiguration {
    private final String configId;
    private final CarConfigUser configUser;
    private final JLRBrand brand;

    public CarConfiguration(String configId, CarConfigUser configUser, JLRBrand brand) {
        this.configId = configId;
        this.configUser = configUser;
        this.brand = brand;
    }

    public String summarize() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarConfiguration that = (CarConfiguration) o;
        return Objects.equals(configId, that.configId) && Objects.equals(configUser, that.configUser) && brand == that.brand;
    }

    @Override
    public int hashCode() {
        return Objects.hash(configId, configUser, brand);
    }
}
