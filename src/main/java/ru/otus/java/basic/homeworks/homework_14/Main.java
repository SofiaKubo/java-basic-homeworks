package ru.otus.java.basic.homeworks.homework_14;

public class Main {
    private static final int ARRAY_SIZE = 100_000_000;
    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {
        runSingleThreaded();
        runMultiThreaded();
    }

    private static void runSingleThreaded() {
        double[] array = new double[ARRAY_SIZE];
        long startTimeNanos = System.nanoTime();

        fillArrayRange(array, 0, array.length);

        long endTimeNanos = System.nanoTime();
        long elapsedTimeNanos = endTimeNanos - startTimeNanos;

        double elapsedTimeSeconds = elapsedTimeNanos / 1_000_000_000.0;
        System.out.printf(
                "Single-threaded execution time: %.3f s%n",
                elapsedTimeSeconds
        );
    }

    private static void runMultiThreaded() throws InterruptedException {
        double[] array = new double[ARRAY_SIZE];
        int chunkSize = array.length / THREAD_COUNT;

        Thread[] threads = new Thread[THREAD_COUNT];

        for (int i = 0; i < threads.length; i++) {
            int startIndex = i * chunkSize;
            int endIndex = (i == THREAD_COUNT - 1) ? array.length : startIndex
                    + chunkSize;

            threads[i] = new Thread(
                    () -> fillArrayRange(array, startIndex, endIndex)
            );
        }

        long startTimeNanos = System.nanoTime();
        for (Thread thread : threads) {
            thread.start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long endTimeNanos = System.nanoTime();
        long elapsedTimeNanos = endTimeNanos - startTimeNanos;

        double elapsedTimeSeconds = elapsedTimeNanos / 1_000_000_000.0;

        System.out.printf(
                "Multi-threaded execution time: %.3f s%n",
                elapsedTimeSeconds
        );
    }

    private static void fillArrayRange(
            double[] array,
            int startIndexInclusive,
            int endIndexExclusive
    ) {
        for (int i = startIndexInclusive; i < endIndexExclusive; i++) {
            array[i] = 1.14
                    * Math.cos(i)
                    * Math.sin(i * 0.2)
                    * Math.cos(i / 1.2);
        }
    }
}
