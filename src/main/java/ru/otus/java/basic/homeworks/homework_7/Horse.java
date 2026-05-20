package ru.otus.java.basic.homeworks.homework_7;

public class Horse implements Transport {
    private final String name;
    private int energy;

    public Horse(String name, int energy) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Horse name must not be blank");
        }

        if (energy < 0) {
            throw new IllegalArgumentException("Horse energy must not be negative");
        }

        this.name = name;
        this.energy = energy;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    private int calculateEnergyConsumption(int distance) {
        return distance;
    }

    private boolean canMoveOn(TerrainType terrainType) {
        return terrainType != TerrainType.SWAMP;
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

        int requiredEnergy = calculateEnergyConsumption(distance);

        if (energy < requiredEnergy) {
            return false;
        }

        energy -= requiredEnergy;
        return true;
    }
}
