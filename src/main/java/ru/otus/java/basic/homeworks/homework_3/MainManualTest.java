package ru.otus.java.basic.homeworks.homework_3;

public class MainManualTest {
    public static void main(String[] args) {
        testSumOfPositiveElements();
        testPrintSquare();
        testZeroMainDiagonal();
        testFindMax();
        testSumSecondRow();
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

    private static void checkSumOfPositiveElements(String testName, int[][] array,
                                                   int expected) {
        int actual = Main.sumOfPositiveElements(array);
        System.out.println(
                testName + ": expected = " + expected + ", actual = " + actual);
    }

    private static void testPrintSquare() {
        printSquareTest(1);
        printSquareTest(0);
        printSquareTest(-1);
        printSquareTest(4);
    }

    private static void printSquareTest(int size) {
        System.out.println("size: " + size);
        Main.printSquare(size);
        System.out.println();
    }

    private static void testZeroMainDiagonal() {
        int[][] firstArray = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

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

        runZeroMainDiagonalTest("firstArray", firstArray);
        runZeroMainDiagonalTest("secondArray", secondArray);
        runZeroMainDiagonalTest("thirdArray", thirdArray);
        runZeroMainDiagonalTest("emptyArray", emptyArray);
        runZeroMainDiagonalTest("nullArray", nullArray);
    }

    private static void runZeroMainDiagonalTest(String testName, int[][] array) {
        System.out.println(testName + ":");
        Main.zeroMainDiagonal(array);
        print2DArray(array);
        System.out.println();
    }

    private static void print2DArray(int[][] arr) {
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

    private static void testFindMax() {
        int[][] firstArray = {
                {-1, 0, 334},
                {4, 5, 17, 5},
                {20, 9}
        };

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

        int[][] emptyRowsArray = {
                {},
                {}
        };

        int[][] nullRowsArray = {
                null,
                null
        };

        int[][] emptyArray = {};
        int[][] nullArray = null;

        checkFindMax("firstArray", firstArray, 334);
        checkFindMax("secondArray", secondArray, 333);
        checkFindMax("thirdArray", thirdArray, 77);
        checkFindMax("fourthArray", fourthArray, -3);
        checkFindMax("emptyRowsArray", emptyRowsArray, 0);
        checkFindMax("nullRowsArray", nullRowsArray, 0);
        checkFindMax("emptyArray", emptyArray, 0);
        checkFindMax("nullArray", nullArray, 0);
    }

    private static void checkFindMax(String testName, int[][] array, int expected) {
        int actual = Main.findMax(array);
        System.out.println(
                testName + ": expected = " + expected + ", actual = " + actual);
    }

    private static void testSumSecondRow() {
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
                {-10, -5}
        };

        int[][] fifthArray = {
                null,
                null
        };

        int[][] sixthArray = {
                {1, 2, 3},
                {}
        };

        int[][] seventhArray = {
                {1, 2, 3},
                {-10, 5, -3}
        };

        int[][] emptyArray = {};
        int[][] nullArray = null;

        checkSumSecondRow("firstArray", firstArray, 15);
        checkSumSecondRow("secondArray", secondArray, 336);
        checkSumSecondRow("thirdArray", thirdArray, -1);
        checkSumSecondRow("fourthArray", fourthArray, -1);
        checkSumSecondRow("fifthArray", fifthArray, -1);
        checkSumSecondRow("sixthArray", sixthArray, 0);
        checkSumSecondRow("seventhArray", seventhArray, -8);
        checkSumSecondRow("emptyArray", emptyArray, -1);
        checkSumSecondRow("nullArray", nullArray, -1);
    }

    private static void checkSumSecondRow(String testName, int[][] array, int expected) {
        int actual = Main.sumSecondRow(array);
        System.out.println(
                testName + ": expected = " + expected + ", actual = " + actual);
    }
}
