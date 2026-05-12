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
            return;
        }

        if (currentFood + amount > maxFood) {
            currentFood = maxFood;
            return;
        }

        currentFood += amount;
    }

    public boolean decreaseFood(int amount) {
        if (amount <= 0) {
            return false;
        }

        if (currentFood < amount) {
            return false;
        }

        currentFood -= amount;
        return true;
    }
}
