package ru.otus.java.basic.homeworks.homework_3;

public class Main {
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

    public static void zeroMainDiagonal(int[][] arr) {
        if (arr == null) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }

            if (i < arr[i].length) {
                arr[i][i] = 0;
            }
        }
    }

    public static int findMax(int[][] arr) {
        if (arr == null) {
            return 0;
        }

        boolean hasElements = false;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                continue;
            }

            for (int j = 0; j < arr[i].length; j++) {
                if (!hasElements) {
                    max = arr[i][j];
                    hasElements = true;
                } else if (arr[i][j] > max) {
                    max = arr[i][j];
                }
            }
        }
        if (!hasElements) {
            return 0;
        }

        return max;
    }

    public static int sumSecondRow(int[][] arr) {
        if (arr == null || arr.length < 2 || arr[1] == null) {
            return -1;
        }

        int sum = 0;

        for (int j = 0; j < arr[1].length; j++) {
            sum += arr[1][j];
        }

        return sum;
    }
}

