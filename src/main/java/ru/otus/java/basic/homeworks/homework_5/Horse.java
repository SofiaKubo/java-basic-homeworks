package ru.otus.java.basic.homeworks.homework_5;

public class Horse extends Animal {
    private static final int SWIM_STAMINA_COST_PER_METER = 4;

    public Horse(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        super(name, runningSpeed, swimmingSpeed, stamina, SWIM_STAMINA_COST_PER_METER);
    }

    @Override
    protected boolean canSwim() {
        return true;
    }
}
