package ru.otus.java.basic.homeworks.homework_8;

public class Main {
    public static void main(String[] args) {
        String[][] validArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidRowCountArray = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"}
        };

        String[][] invalidColumnCountArray = {
                {"1", "2", "3", "4"},
                {"5", "6"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        String[][] invalidDataArray = {
                {"1", "2", "3", "4"},
                {"5", "invalid", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };

        testArray("Correct 4x4 array", validArray);
        testArray("Invalid row count array", invalidRowCountArray);
        testArray("Invalid column count array", invalidColumnCountArray);
        testArray("Invalid data array", invalidDataArray);
    }

    private static void testArray(String testName, String[][] array) {
        System.out.println("Test: " + testName);

        try {
            int result = sumArray(array);
            System.out.println("Sum: " + result);
        } catch (AppArraySizeException e) {
            System.out.println("Size error: " + e.getMessage());
        } catch (AppArrayStructureException e) {
            System.out.println("Structure error: " + e.getMessage());
        } catch (AppArrayDataException e) {
            System.out.println("Data error: " + e.getMessage());

            if (e.getCause() != null) {
                System.out.println("Cause: "
                        + e.getCause().getClass().getSimpleName()
                        + ": " + e.getCause().getMessage());
            }
        }
        System.out.println();
    }

    private static final int REQUIRED_ARRAY_SIZE = 4;

    private static int sumArray(String[][] array)
            throws AppArraySizeException, AppArrayStructureException,
            AppArrayDataException {

        if (array == null) {
            throw new AppArraySizeException(
                    "Array is null. Expected 4x4 array."
            );
        }

        if (array.length != REQUIRED_ARRAY_SIZE) {
            throw new AppArraySizeException(
                    "Invalid row count. Expected " + REQUIRED_ARRAY_SIZE
                            + ", actual: " + array.length + "."
            );
        }

        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            String[] row = array[i];

            if (row == null) {
                throw new AppArrayStructureException(
                        "Invalid array structure: row " + i + " is null."
                );
            }

            if (row.length != REQUIRED_ARRAY_SIZE) {
                throw new AppArraySizeException(
                        "Invalid column count in row " + i
                                + ". Expected " + REQUIRED_ARRAY_SIZE
                                + ", actual: " + row.length + "."
                );
            }

            for (int j = 0; j < row.length; j++) {
                String value = row[j];

                try {
                    sum += Integer.parseInt(value);
                } catch (NumberFormatException e) {
                    throw new AppArrayDataException(
                            "Invalid data at cell [" + i + "][" + j + "]: \""
                                    + value + "\" cannot be converted to int.",
                            e
                    );
                }
            }
        }
        return sum;
    }
}
