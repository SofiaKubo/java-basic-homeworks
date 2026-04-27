package ru.otus.java.basic.homeworks.homework_2;

import java.util.Arrays;

public class AdvancedTasks {
    public static void main(String[] args) {
        testSumArrays();
        testBalancePoint();
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
}

