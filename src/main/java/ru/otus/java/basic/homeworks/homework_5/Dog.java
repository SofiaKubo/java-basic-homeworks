package ru.otus.java.basic.homeworks.homework_5;

public class Dog extends Animal {
    private static final int SWIM_STAMINA_COST_PER_METER = 2;

    public Dog(String name, int runningSpeed, int swimmingSpeed, int stamina) {
        super(name, runningSpeed, swimmingSpeed, stamina, SWIM_STAMINA_COST_PER_METER);
    }

    @Override
    protected boolean canSwim() {
        return true;
    }
}
