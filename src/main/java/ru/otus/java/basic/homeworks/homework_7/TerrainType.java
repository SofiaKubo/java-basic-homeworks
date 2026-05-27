package ru.otus.java.basic.homeworks.homework_7;

public enum TerrainType {
    PLAIN("равнина"),
    FOREST("густой лес"),
    SWAMP("болото");

    private final String displayName;

    TerrainType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
