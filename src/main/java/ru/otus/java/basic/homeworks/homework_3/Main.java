package ru.otus.java.basic.homeworks.homework_3;

public class Main {
    public static void main(String[] args) {
//        testSumOfPositiveElements();
        testPrintSquare();
//        testZeroMainDiagonal();
//        testFindMax();
//        testSumSecondRow();
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

        int[][] arrayWithZeros = {
                {0, 1, 2},
                {0, -5, 3}
        };

        int[][] arrayWithEmptyRow = {
                {},
                {1, 2, 3}
        };

        int[][] emptyArray = {};
        int[][] nullArray = null;

        checkSumOfPositiveElements("firstArray", firstArray, 0);
        checkSumOfPositiveElements("secondArray", secondArray, 6);
        checkSumOfPositiveElements("thirdArray", thirdArray, 117);
        checkSumOfPositiveElements("arrayWithZeros", arrayWithZeros, 6);
        checkSumOfPositiveElements("arrayWithEmptyRow", arrayWithEmptyRow, 6);
        checkSumOfPositiveElements("emptyArray", emptyArray, 0);
        checkSumOfPositiveElements("nullArray", nullArray, 0);
    }

    private static void checkSumOfPositiveElements(String testName, int[][] array, int expected) {
        int actual = sumOfPositiveElements(array);
        System.out.println(
                testName + ": expected = " + expected + ", actual = " + actual);
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
        printSquareTest(1);
        printSquareTest(0);
        printSquareTest(-1);
        printSquareTest(4);
    }

    private static void printSquareTest(int size) {
        System.out.println("size: " + size);
        printSquare(size);
        System.out.println();
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

    public static void testSumSecondRow() {
        int[][] firstArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[][] secondArray = {
                null,
                {1, 2, 333}
        };

        int[][] thirdArray = {
                {1, 2, 3},
                null,
                {5, 6, 77}
        };
        int[][] fourthArray = {
                {-10, -5},
        };

        int[][] fifthArray = {
                null,
                null
        };

        int[][] sixthArray = {
                {1, 2, 3},
                {}
        };

        int[][] emptyArray = {};
        int[][] nullArray = null;


        System.out.println(
                "firstArray = " + sumSecondRow(firstArray));
        System.out.println(
                "secondArray = " + sumSecondRow(secondArray));
        System.out.println(
                "thirdArray = " + sumSecondRow(thirdArray));
        System.out.println(
                "fourthArray = " + sumSecondRow(fourthArray));
        System.out.println(
                "fifthArray = " + sumSecondRow(fifthArray));
        System.out.println(
                "sixthArray = " + sumSecondRow(sixthArray));
        System.out.println(
                "emptyArray = " + sumSecondRow(emptyArray));
        System.out.println(
                "nullArray = " + sumSecondRow(nullArray));
    }
}

