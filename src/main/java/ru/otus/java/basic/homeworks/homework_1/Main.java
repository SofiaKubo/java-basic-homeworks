package ru.otus.java.basic.homeworks.homework_1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.print("Выберите метод (1-5): ");
            if (!scanner.hasNextInt()) {
                System.out.println("Ошибка: нужно ввести целое число.");
                scanner.next();
                continue;
            }
            choice = scanner.nextInt();

            if (choice < 1 || choice > 5) {
                System.out.println("Такого метода нет. Допустимы только значения от 1 до 5.");
                continue;
            }
            break;
        }

        switch (choice) {
            case 1:
                greetings();
                break;
            case 2:
                System.out.println("Введите a, b, c:");
                checkSign(scanner.nextInt(), scanner.nextInt(), scanner.nextInt());
                break;
            case 3:
                System.out.println("Введите data:");
                selectColor(scanner.nextInt());
                break;
            case 4:
                System.out.println("Введите a, b:");
                compareNumbers(scanner.nextInt(), scanner.nextInt());
                break;
            case 5:
                System.out.println("Введите initValue, delta, increment (true/false):");
                addOrSubtractAndPrint(scanner.nextInt(), scanner.nextInt(), scanner.nextBoolean());
                break;
        }
        scanner.close();
    }

    private static void greetings() {
        System.out.println("Hello");
        System.out.println("World");
        System.out.println("from");
        System.out.println("Java");
    }

    private static void checkSign(int a, int b, int c) {
        int sum = a + b + c;
        System.out.println(
                sum >= 0 ? "Сумма положительная." : "Сумма отрицательная.");
    }

    // Дополнительный вариант без параметров: значения заданы внутри по требованиям ДЗ.
    private static void selectColor() {
        int data = 15;
        selectColor(data);
    }

    private static void selectColor(int data) {
        if (data <= 10) {
            System.out.println("Красный");
        } else if (data <= 20) {
            System.out.println("Желтый");
        } else {
            System.out.println("Зеленый");
        }
    }

    // Дополнительный вариант без параметров: значения заданы внутри по требованиям ДЗ.
    private static void compareNumbers() {
        int a = 10;
        int b = 20;
        compareNumbers(a, b);
    }

    private static void compareNumbers(int a, int b) {
        System.out.println(a >= b ? "a >= b" : "a < b");
    }

    private static void addOrSubtractAndPrint(int initValue, int delta, boolean increment) {
        int result = increment ? initValue + delta : initValue - delta;
        System.out.println(result);
    }
}
