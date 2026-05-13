package ru.otus.java.basic.homeworks.homework_6;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate(100);

        Cat barsik = new Cat("Барсик", 10);
        Cat kasper = new Cat("Каспер", 20);
        Cat rocky = new Cat("Рокки", 35);
        Cat perchik = new Cat("Перчик", 25);
        Cat simba = new Cat("Симба", 45);

        Cat[] cats = {barsik, kasper, rocky, perchik, simba};

        System.out.printf("\nНачальное состояние тарелки:%n%s%n", plate);

        System.out.println("\nНачальное состояние котов:");
        for (Cat cat : cats) {
            System.out.printf("%n%s%n", cat);
        }

        System.out.println("\nПора кормить котиков:");
        for (Cat cat : cats) {
            cat.eat(plate);
            System.out.printf("%n%s%n", cat);
        }

        for (Cat cat : cats) {
            if (!cat.isFull()) {
                System.out.println("\nЕды на всех не хватило, наполняем тарелку:");
                plate.addFood(100);
                System.out.printf("%s%n", plate);
                cat.eat(plate);
            }
        }

        System.out.println("\nУра, теперь все котики сытые!");
        for (Cat cat : cats) {
            System.out.printf("%n%s%n", cat);
        }

        System.out.printf("\nКонечное состояние тарелки:%n%s%n", plate);
    }
}
