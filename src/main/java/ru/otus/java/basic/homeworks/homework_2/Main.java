package ru.otus.java.basic.homeworks.homework_2;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        printStringNTimes(5, "Homework_2");
        sumMoreThanFive(new int[]{2, 14, -3, 22, 5});
        fillArray(3, new int[5]);
        increaseArrayElements(2, new int[]{2, 14, -3, 22, 5});
        printGreaterHalfSum(new int[]{4, 6, 2, 3, 4});
        printGreaterHalfSum(new int[]{0, 1, 2, 3});
        printGreaterHalfSum(new int[]{1, 1, 1, 1});
    }

    public static void printStringNTimes(int count, String text) {
        for (int i = 0; i < count; i++) {
            System.out.println(text);
        }
    }

    public static void sumMoreThanFive(int[] array) {
        int sum = 0;
        for (int number : array) {
            if (number > 5) {
                sum += number;
            }
        }
        System.out.println(sum);
    }

    public static void fillArray(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = value;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void increaseArrayElements(int value, int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] += value;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void printGreaterHalfSum(int[] array) {
        int leftSum = 0;
        int rightSum = 0;
        int mid = array.length / 2;

        for (int i = 0; i < mid; i++) {
            leftSum += array[i];
        }

        for (int i = array.length % 2 == 0 ? mid : mid + 1;
             i < array.length; i++) {
            rightSum += array[i];
        }

        if (leftSum > rightSum) {
            System.out.println("Сумма левой половины больше");
        } else if (rightSum > leftSum) {
            System.out.println("Сумма правой половины больше");
        } else {
            System.out.println("Суммы половин равны");
        }
    }
}
