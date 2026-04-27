package ru.otus.java.basic.homeworks.homework_2;

import java.util.Arrays;

public class AdvancedTasks {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3};
        int[] secondArray = {2, 2};
        int[] thirdArray = {1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(sumArrays(firstArray, secondArray, thirdArray)));

        int[] testArrayFirst = {1, 1, 1, 1, 1, 5};
        int[] testArraySecond = {5, 3, 4, -2};
        int[] testArrayThird = {7, 2, 2, 2};
        int[] testArrayFourth = {9, 4};
        int[] emptyArray = {};
        int[] nullArray = null;

        System.out.println(hasBalancePoint(testArrayFirst));
        System.out.println(hasBalancePoint(testArraySecond));
        System.out.println(hasBalancePoint(testArrayThird));
        System.out.println(hasBalancePoint(testArrayFourth));
        System.out.println(hasBalancePoint(emptyArray));
        System.out.println(hasBalancePoint(nullArray));

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
}

