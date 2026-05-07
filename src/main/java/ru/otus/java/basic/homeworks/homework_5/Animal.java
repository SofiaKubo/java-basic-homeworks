package ru.otus.java.basic.homeworks.homework_5;

public abstract class Animal {
    private final String name;
    private final int runningSpeed;
    private final int swimmingSpeed;
    private int stamina;
    private boolean tired;

    private static final int RUN_STAMINA_COST_PER_METER = 1;

    public Animal(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        this.name = name;
        this.runningSpeed = runningSpeed;
        this.swimmingSpeed = swimmingSpeed;
        this.stamina = stamina;
        this.tired = false;
    }

    protected abstract boolean canSwim();

    protected abstract int getSwimStaminaCostPerMeter();

    private double performAction(
            int distance,
            int speed,
            int staminaCostPerMeter,
            boolean actionAllowed,
            String actionName
    ) {
        if (distance <= 0) {
            System.out.println("Дистанция должна быть положительной.");
            return -1;
        }

        if (!actionAllowed) {
            System.out.println(name + " не умеет плавать.");
            return -1;
        }

        if (speed <= 0) {
            System.out.println("Скорость должна быть положительной.");
            return -1;
        }

        int requiredStamina = distance * staminaCostPerMeter;

        if (stamina < requiredStamina) {
            tired = true;
            System.out.println(
                    name + " устал и не может " + actionName + " " + distance +
                            " м.");
            return -1;
        }
        stamina -= requiredStamina;

        tired = stamina == 0;

        double time = (double) distance / speed;
        System.out.println(
                name + " смог " + actionName + " " + distance + " м за " +
                        time + " сек.");
        return time;
    }

    public double run(int distance) {
        return performAction(
                distance,
                runningSpeed,
                RUN_STAMINA_COST_PER_METER,
                true,
                "пробежать"
        );
    }

    public double swim(int distance) {
        return performAction(
                distance,
                swimmingSpeed,
                getSwimStaminaCostPerMeter(),
                canSwim(),
                "проплыть"
        );
    }

    public void info() {
        System.out.println(
                "Животное: " + name +
                        ", скорость бега: " + runningSpeed +
                        ", скорость плавания: " + swimmingSpeed +
                        ", выносливость: " + stamina +
                        ", состояние: " + (tired ? "устал" : "не устал")
        );
    }
}
