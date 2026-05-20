package ru.otus.java.basic.homeworks.homework_7;

public class AllTerrainVehicle extends FuelTransport {
    private static final int FUEL_CONSUMPTION_MULTIPLIER = 2;

    public AllTerrainVehicle(String transportName, int fuelAmount) {
        super(transportName, fuelAmount);
    }

    @Override
    protected boolean canMoveOn(TerrainType terrainType) {
        return true;
    }

    @Override
    protected int calculateFuelConsumption(int distance) {
        return distance * FUEL_CONSUMPTION_MULTIPLIER;
    }
}
