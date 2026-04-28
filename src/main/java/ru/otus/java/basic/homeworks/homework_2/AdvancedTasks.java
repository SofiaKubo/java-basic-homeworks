package ru.otus.java.basic.homeworks.homework_2;

import java.util.Arrays;

public class AdvancedTasks {
    public static void main(String[] args) {
//        testSumArrays();
//        testBalancePoint();
        testInSelectedDirection();
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

        System.out.println(Arrays.toString(testArrayFirst) + " -> " +
                hasBalancePoint(testArrayFirst));
        System.out.println(Arrays.toString(testArraySecond) + " -> " +
                hasBalancePoint(testArraySecond));
        System.out.println(Arrays.toString(testArrayThird) + " -> " +
                hasBalancePoint(testArrayThird));
        System.out.println(Arrays.toString(testArrayFourth) + " -> " +
                hasBalancePoint(testArrayFourth));
        System.out.println(Arrays.toString(emptyArray) + " -> " +
                hasBalancePoint(emptyArray));
        System.out.println(Arrays.toString(nullArray) + " -> " +
                hasBalancePoint(nullArray));
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

    private static void testInSelectedDirection() {
        int[] testArrayFirst = {1, 2, 5};
        int[] testArraySecond = {5, 3, 1, -2};
        int[] testArrayThird = {7, 12, 1};
        int[] testArrayFourth = {9};
        int[] emptyArray = {};
        int[] nullArray = null;

        System.out.println(Arrays.toString(testArrayFirst) + " -> " +
                isSortedInSelectedDirection(testArrayFirst, 1));
        System.out.println(Arrays.toString(testArraySecond) + " -> " +
                isSortedInSelectedDirection(testArraySecond, 2));
        System.out.println(Arrays.toString(testArrayThird) + " -> " +
                isSortedInSelectedDirection(testArrayThird, 1));
        System.out.println(Arrays.toString(testArrayFourth) + " -> " +
                isSortedInSelectedDirection(testArrayFourth, 2));
        System.out.println(Arrays.toString(emptyArray) + " -> " +
                isSortedInSelectedDirection(emptyArray, 1));
        System.out.println(Arrays.toString(nullArray) + " -> " +
                isSortedInSelectedDirection(nullArray, 1));
    }
}

