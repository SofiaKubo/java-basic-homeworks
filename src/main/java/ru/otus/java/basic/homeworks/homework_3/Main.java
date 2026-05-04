package ru.otus.java.basic.homeworks.homework_3;

public class Main {
    public static void main(String[] args) {
//        testSumOfPositiveElements();
//        testPrintSquare();
//        testZeroMainDiagonal();
        testFindMax();
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

    private static void testZeroMainDiagonal() {
        int[][] firstArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}};


        int[][] secondArray = {
                null,
                {1, 2, 3}
        };

        int[][] thirdArray = {
                {1, 2, 3},
                {4},
                {5, 6, 7}
        };

        int[][] emptyArray = {};
        int[][] nullArray = null;

        System.out.println("firstArray:");
        zeroMainDiagonal(firstArray);
        print2DArray(firstArray);

        System.out.println("secondArray:");
        zeroMainDiagonal(secondArray);
        print2DArray(secondArray);

        System.out.println("thirdArray:");
        zeroMainDiagonal(thirdArray);
        print2DArray(thirdArray);

        System.out.println("emptyArray:");
        zeroMainDiagonal(emptyArray);
        print2DArray(emptyArray);

        System.out.println("nullArray:");
        zeroMainDiagonal(nullArray);
        print2DArray(nullArray);
    }

    public static void print2DArray(int[][] arr) {
        if (arr == null) {
            System.out.println("null");
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == null) {
                System.out.println("null");
                continue;
            }
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
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

        return max;
    }

    public static void testFindMax() {
        int[][] firstArray = {
                {-1, 0, 334},
                {4, 5, 17, 5},
                {20, 9}};


        int[][] secondArray = {
                null,
                {1, 2, 333}
        };

        int[][] thirdArray = {
                {1, 2, 3},
                {4},
                {5, 6, 77}
        };
        int[][] fourthArray = {
            {-10, -5},
            {-3, -8}
        };

        int[][] emptyArray = {};
        int[][] nullArray = null;


        System.out.println(
                "firstArrayMaxElement = " + findMax(firstArray));
        System.out.println(
                "secondArrayMaxElement = " + findMax(secondArray));
        System.out.println(
                "thirdArrayMaxElement = " + findMax(thirdArray));
        System.out.println(
                "fourthArrayMaxElement = " + findMax(fourthArray));
        System.out.println(
                "emptyArrayMaxElement = " + findMax(emptyArray));
        System.out.println(
                "nullArrayMaxElement = " + findMax(nullArray));
    }
}

