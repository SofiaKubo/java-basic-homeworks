package ru.otus.java.basic.homeworks.homework_6;

public class Plate {
    private final int maxFood;
    private int currentFood;

    public Plate(int maxFood) {
        if (maxFood <= 0) {
            throw new IllegalArgumentException("Plate capacity must be positive");
        }

        this.maxFood = maxFood;
        this.currentFood = maxFood;
    }

    public void addFood(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Food amount must be positive");
        }

        int availableSpace = maxFood - currentFood;
        if (amount >= availableSpace) {
            currentFood = maxFood;
            return;
        }

        currentFood += amount;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Food amount must be positive");
        }

        if (currentFood < amount) {
            return false;
        }

        currentFood -= amount;
        return true;
    }

    public int getMaxFood() {
        return maxFood;
    }

    public int getCurrentFood() {
        return currentFood;
    }

    @Override
    public String toString() {
        return "Plate{" +
                "maxFood=" + maxFood +
                ", currentFood=" + currentFood +
                '}';
    }
}
