package ru.otus.java.basic.homeworks.homework_5;

public class Cat extends Animal {
    private static final int SWIM_SPEED = 0;
    private static final int SWIM_STAMINA_COST_PER_METER = 0;

    public Cat(String name, int runningSpeed, int stamina) {
        super(name, runningSpeed, SWIM_SPEED, stamina);
    }

    @Override
    protected boolean canSwim() {
        return false;
    }

    @Override
    protected int getSwimStaminaCostPerMeter() {
        return SWIM_STAMINA_COST_PER_METER;
    }
}
