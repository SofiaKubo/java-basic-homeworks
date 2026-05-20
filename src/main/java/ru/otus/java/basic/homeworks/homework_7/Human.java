package ru.otus.java.basic.homeworks.homework_7;

public class Human {
    private final String name;
    private Transport currentTransport;

    public Human(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Human name must not be blank");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Transport getCurrentTransport() {
        return currentTransport;
    }

    public void takeTransport(Transport transport) {
        if (transport == null) {
            throw new IllegalArgumentException("Transport must not be null");
        }

        if (currentTransport != null) {
            throw new IllegalStateException("Cannot take transport twice");
        }

        currentTransport = transport;
        System.out.println(
                "Посадка выполнена: человек \"" + name +
                        "\", транспорт \"" + currentTransport.getName() + "\".");
    }

    public void leaveTransport() {
        if (currentTransport == null) {
            System.out.println(
                    "Высадка не выполнена: человек \"" + name +
                            "\" не использует транспорт.");
            return;
        }

        String transportName = currentTransport.getName();
        currentTransport = null;
        System.out.println(
                "Высадка выполнена: человек \"" + name +
                        "\", транспорт \"" + transportName + "\".");
    }

    public boolean move(int distance, TerrainType terrainType) {
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance must be positive");
        }

        if (terrainType == null) {
            throw new IllegalArgumentException("Terrain type must not be null");
        }

        if (currentTransport == null) {
            System.out.println(
                    "Перемещение выполнено: человек \"" + name +
                            "\", пешком, расстояние " + distance +
                            " км, местность: " +
                            terrainType.getDisplayName() + ".");
            return true;
        }

        boolean result = currentTransport.move(distance, terrainType);

        if (result) {
            System.out.println(
                    "Перемещение выполнено: человек \"" + name +
                            "\", транспорт \"" + currentTransport.getName() +
                            "\", расстояние " + distance +
                            " км, местность: " +
                            terrainType.getDisplayName() + ".");
            return true;
        }

        System.out.println(
                "Перемещение не выполнено: человек \"" + name +
                        "\", транспорт \"" + currentTransport.getName() +
                        "\", расстояние " + distance +
                        " км, местность: " +
                        terrainType.getDisplayName() + ".");
        return false;
    }
}
