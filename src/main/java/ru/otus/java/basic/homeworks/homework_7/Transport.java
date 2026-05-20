package ru.otus.java.basic.homeworks.homework_7;

public interface Transport {
    boolean move(int distance, TerrainType terrainType);

    String getName();
}
