package ru.otus.java.basic.homeworks.homework_2;

import java.util.Arrays;

public class AdvancedTasks {
    public static void main(String[] args) {
        testSumArrays();
        testBalancePoint();
        testSortedInSelectedDirection();
        testReverseArray();
    }

    public static int[] sumArrays(int[]... arrays) {
        int maxLength = 0;
        for (int[] currentArray : arrays) {
            if (currentArray == null) {
                continue;
            }
            maxLength = Math.max(maxLength, currentArray.length);
        }

        int[] result = new int[maxLength];

        for (int[] currentArray : arrays) {
            if (currentArray == null) {
                continue;
            }

            for (int i = 0; i < currentArray.length; i++) {
                result[i] += currentArray[i];
            }
        }
        return result;
    }

    private static void testSumArrays() {
        int[] firstArray = {1, 2, 3};
        int[] secondArray = {2, 2};
        int[] thirdArray = {1, 1, 1, 1, 1};

        int[] result = sumArrays(firstArray, secondArray, thirdArray);

        System.out.println(Arrays.toString(result));
    }

    public static boolean hasBalancePoint(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return false;
        }

        int sum = 0;
        int leftSum = 0;

        for (int number : numbers) {
            sum += number;
        }

        for (int i = 0; i < numbers.length - 1; i++) {
            leftSum += numbers[i];
            int rightSum = sum - leftSum;
            if (leftSum == rightSum) {
                return true;
            }
        }
        return false;
    }

    private static void testBalancePoint() {
        int[] testArrayFirst = {1, 1, 1, 1, 1, 5};
        int[] testArraySecond = {5, 3, 4, -2};
        int[] testArrayThird = {7, 2, 2, 2};
        int[] testArrayFourth = {9, 4};
        int[] emptyArray = {};
        int[] nullArray = null;

        printBalancePointTest(testArrayFirst);
        printBalancePointTest(testArraySecond);
        printBalancePointTest(testArrayThird);
        printBalancePointTest(testArrayFourth);
        printBalancePointTest(emptyArray);
        printBalancePointTest(nullArray);
    }

    private static void printBalancePointTest(int[] array) {
        System.out.println(Arrays.toString(array) + " -> " +
                hasBalancePoint(array));
    }

    private static boolean isSortedInSelectedDirection(int[] array, int userChoice) {
        if (array == null) {
            return false;
        }

        if (userChoice != 1 && userChoice != 2) {
            return false;
        }

        if (array.length < 2) {
            return true;
        }

        if (userChoice == 1) { // Choice 1 means increasing
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    return false;
                }
            }
            return true;
        } else { // Choice 2 means decreasing
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] < array[i + 1]) {
                    return false;
                }
            }
            return true;
        }
    }

    private static void testSortedInSelectedDirection() {
        int[] testArrayFirst = {1, 2, 5};
        int[] testArraySecond = {5, 3, 1, -2};
        int[] testArrayThird = {7, 12, 1};
        int[] testArrayFourth = {9};
        int[] emptyArray = {};
        int[] nullArray = null;
        int[] equalElementsArray = {2, 2, 2};

        printSortedDirectionTest(testArrayFirst, 1);
        printSortedDirectionTest(testArraySecond, 2);
        printSortedDirectionTest(testArrayThird, 1);
        printSortedDirectionTest(testArrayFourth, 2);
        printSortedDirectionTest(emptyArray, 1);
        printSortedDirectionTest(nullArray, 1);
        printSortedDirectionTest(equalElementsArray, 1);
        printSortedDirectionTest(equalElementsArray, 2);
        printSortedDirectionTest(testArrayFirst, 3);
    }

    private static void printSortedDirectionTest(int[] array, int userChoice) {
        System.out.println(Arrays.toString(array) +
                ", direction = " + userChoice +
                " -> " + isSortedInSelectedDirection(array, userChoice));
    }

    private static void reverseArray(int[] array) {
        if (array == null) {
            return;
        }

        if (array.length < 2) {
            return;
        }

        int mid = array.length / 2;

        for (int i = 0; i < mid; i++) {
            int oppositeIndex = array.length - 1 - i;

            int temp = array[i];
            array[i] = array[oppositeIndex];
            array[oppositeIndex] = temp;
        }
    }

    private static void testReverseArray() {
        int[] testArrayFirst = {1, 2, 3, 4, 5, 6};
        int[] testArraySecond = {7, 5, 3, 1, 0};
        int[] testArrayThird = {9};
        int[] emptyArray = {};
        int[] nullArray = null;

        printReverseArrayTest(testArrayFirst);
        printReverseArrayTest(testArraySecond);
        printReverseArrayTest(testArrayThird);
        printReverseArrayTest(emptyArray);
        printReverseArrayTest(nullArray);
    }

    private static void printReverseArrayTest(int[] array) {
        String before = Arrays.toString(array);

        reverseArray(array);

        System.out.println(before + " -> " + Arrays.toString(array));
    }
}

