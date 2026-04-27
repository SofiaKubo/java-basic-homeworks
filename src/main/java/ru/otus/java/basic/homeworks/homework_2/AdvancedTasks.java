package ru.otus.java.basic.homeworks.homework_2;

import java.util.Arrays;

public class AdvancedTasks {
    public static void main(String[] args) {
        int[] firstArray = {1, 2, 3};
        int[] secondArray = {2, 2};
        int[] thirdArray = {1, 1, 1, 1, 1};

        System.out.println(Arrays.toString(sumArrays(firstArray, secondArray, thirdArray)));
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
}
