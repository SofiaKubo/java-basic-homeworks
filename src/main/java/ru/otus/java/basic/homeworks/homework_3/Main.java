package ru.otus.java.basic.homeworks.homework_3;

public class Main {
    public static void main(String[] args) {
        testSumOfPositiveElements();
        testPrintSquare();
    }

    public static int sumOfPositiveElements(int[][] arr) {
        if (arr == null) {
            return 0;
        }

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] > 0) {
                    sum += arr[i][j];
                }
            }
        }
        return sum;
    }

    private static void testSumOfPositiveElements() {
        int[][] firstArray = {
                {-1, -2, -3},
                {-4, -5, -6, -7},
                {-8, -9}
        };

        int[][] secondArray = {
                null,
                {1, 2, 3}
        };

        int[][] thirdArray = {
                {-1, 82, -3, -19},
                {4, -15, 6},
                {7, 8, 10}
        };

        int[][] emptyArray = {};
        int[][] nullArray = null;

        System.out.println(
                "firstArraySum = " + sumOfPositiveElements(firstArray));
        System.out.println(
                "secondArraySum = " + sumOfPositiveElements(secondArray));
        System.out.println(
                "thirdArraySum = " + sumOfPositiveElements(thirdArray));
        System.out.println(
                "emptyArraySum = " + sumOfPositiveElements(emptyArray));
        System.out.println(
                "nullArraySum = " + sumOfPositiveElements(nullArray));
    }

    public static void printSquare(int size) {
        if (size <= 0) {
            return;
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void testPrintSquare() {
        System.out.println("size: 1");
        printSquare(1);

        System.out.println("size: -1");
        printSquare(-1);

        System.out.println("size: 4");
        printSquare(4);
    }
}
