package ru.otus.java.basic.homeworks.homework_7;

public class Bicycle implements Transport {
    private final String model;

    public Bicycle(String model) {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException("Bicycle model must not be blank");
        }

        this.model = model;
    }

    @Override
    public String getName() {
        return model;
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

        return canMoveOn(terrainType);
    }
}
