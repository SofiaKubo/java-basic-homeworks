package ru.otus.java.basic.homeworks.homework_6;

public class Cat {
    private final String name;
    private final int appetite;
    private boolean isFull;

    public Cat(String name, int appetite) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Cat name must not be blank");
        }

        if (appetite <= 0) {
            throw new IllegalArgumentException("Cat appetite must be positive");
        }

        this.name = name;
        this.appetite = appetite;
        this.isFull = false;
    }

    public void eat(Plate plate) {
        if (plate == null) {
            throw new IllegalArgumentException("Plate must not be null");
        }

        isFull = plate.decreaseFood(appetite);
    }

    @Override
    public String toString() {
        return "Cat {" +
                "имя = " + name +
                ", аппетит = " + appetite + " у.е," +
                ", сытость = " + (isFull ? "сытый" : "голодный.") +
                '}';
    }
}
