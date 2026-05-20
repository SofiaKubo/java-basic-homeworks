package ru.otus.java.basic.homeworks.homework_7;

public class Car extends FuelTransport {

    public Car(String transportName, int fuelAmount) {
        super(transportName, fuelAmount);
    }

    @Override
    protected boolean canMoveOn(TerrainType terrainType) {
        return terrainType == TerrainType.PLAIN;
    }
}
