package ru.otus.java.basic.homeworks.homework_5;

public class Main {
    public static void main(String[] args) {
        Cat barsik = new Cat("Барсик", 3, 25);
        Dog sharik = new Dog("Шарик", 5, 3, 35);
        Horse bruno = new Horse("Бруно", 15, 7, 50);

        Animal[] animals = {barsik, sharik, bruno};

        System.out.println("Начальное состояние животных:");
        for (Animal animal : animals) {
            animal.info();
            System.out.println();
        }

        System.out.println("Проверка бега на дистанции 15 м:");
        for (Animal animal : animals) {
            double runTime = animal.run(15);
            System.out.printf("Результат: %.2f.%n", runTime);
            animal.info();
            System.out.println();
        }

        System.out.println("Проверка некорректной дистанции для бега:");
        for (Animal animal : animals) {
            double runTime = animal.run(-15);
            System.out.printf("Результат: %.2f.%n", runTime);
            System.out.println();
        }

        System.out.println("Проверка плавания:");

        double catSwimTime = barsik.swim(10);
        System.out.printf("Результат: %.2f.%n", catSwimTime);
        barsik.info();
        System.out.println();

        double dogSwimTime = sharik.swim(10);
        System.out.printf("Результат: %.2f.%n", dogSwimTime);
        sharik.info();
        System.out.println();

        double horseSwimTime = bruno.swim(8);
        System.out.printf("Результат: %.2f.%n", horseSwimTime);
        bruno.info();
        System.out.println();

        System.out.println("Проверка усталости на большой дистанции:");
        for (Animal animal : animals) {
            double runTime = animal.run(100);
            System.out.printf("Результат: %.2f.%n", runTime);
            animal.info();
            System.out.println();
        }
    }
}
