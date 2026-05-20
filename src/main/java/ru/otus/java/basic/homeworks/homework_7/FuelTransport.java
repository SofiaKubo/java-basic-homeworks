package ru.otus.java.basic.homeworks.homework_7;

public abstract class FuelTransport implements Transport {
    private final String transportName;
    private int fuelAmount;

    public FuelTransport(String transportName, int fuelAmount) {
        if (transportName == null || transportName.isBlank()) {
            throw new IllegalArgumentException("Transport name must not be blank");
        }

        if (fuelAmount < 0) {
            throw new IllegalArgumentException("Transport fuel amount must not be negative");
        }

        this.transportName = transportName;
        this.fuelAmount = fuelAmount;
    }

    @Override
    public String getName() {
        return transportName;
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    protected abstract boolean canMoveOn(TerrainType terrainType);

    protected int calculateFuelConsumption(int distance) {
        return distance;
    }

    @Override
    public boolean move(int distance, TerrainType terrainType) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }

        if (terrainType == null) {
            throw new IllegalArgumentException("Terrain type must not be null");
        }

        if (!canMoveOn(terrainType)) {
            return false;
        }

        int requiredFuel = calculateFuelConsumption(distance);

        if (fuelAmount < requiredFuel) {
            return false;
        }

        fuelAmount -= requiredFuel;
        return true;
    }
}
