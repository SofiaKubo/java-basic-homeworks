package ru.otus.java.basic.homeworks.homework_11;

import java.util.Arrays;
import java.util.List;

public class Main {
    private static int checksPassed = 0;

    public static void main(String[] args) {
        runManualTests();
        System.out.println();
        System.out.println("Manual tests finished successfully.");
        System.out.println("Checks passed: " + checksPassed);
    }

    private static void runManualTests() {
        testSearchInFilledTree();
        testEmptyTree();
        testTreeWithDuplicates();
        testInvalidConstructorArguments();
        testFindRejectsNull();
        testSortedListIsImmutable();
    }

    private static void testSearchInFilledTree() {
        System.out.println("Test case: search in a filled tree");
        SearchTree<Integer> tree = new BinarySearchTree<>(List.of(1, 4, 7, 9, 12, 15, 20));

        assertEquals(1, tree.find(1), "find should return the first element");
        assertEquals(9, tree.find(9), "find should return the middle element");
        assertEquals(20, tree.find(20), "find should return the last element");
        assertEquals(null, tree.find(100), "find should return null for a missing element");
        assertEquals(List.of(1, 4, 7, 9, 12, 15, 20), tree.getSortedList(),
                "getSortedList should return all elements in ascending order");
        System.out.println();
    }

    private static void testEmptyTree() {
        System.out.println("Test case: empty tree");
        SearchTree<Integer> emptyTree = new BinarySearchTree<>(List.<Integer>of());

        assertEquals(null, emptyTree.find(1), "find should return null for an empty tree");
        assertEquals(List.of(), emptyTree.getSortedList(), "empty tree should return an empty list");
        System.out.println();
    }

    private static void testTreeWithDuplicates() {
        System.out.println("Test case: tree with duplicates");
        SearchTree<Integer> tree = new BinarySearchTree<>(List.of(1, 2, 2, 2, 3));

        assertEquals(2, tree.find(2), "find should return an existing duplicate value");
        assertEquals(List.of(1, 2, 2, 2, 3), tree.getSortedList(),
                "duplicates should be preserved in sorted order");
        System.out.println();
    }

    private static void testInvalidConstructorArguments() {
        System.out.println("Test case: invalid constructor arguments");
        assertThrows(() -> new BinarySearchTree<Integer>(null),
                "constructor should reject null list");
        assertThrows(() -> new BinarySearchTree<>(List.of(3, 2, 1)),
                "constructor should reject unsorted list");
        assertThrows(() -> new BinarySearchTree<>(Arrays.asList(1, null, 3)),
                "constructor should reject null elements");
        System.out.println();
    }

    private static void testFindRejectsNull() {
        System.out.println("Test case: find rejects null");
        SearchTree<Integer> tree = new BinarySearchTree<>(List.of(1, 2, 3));
        assertThrows(() -> tree.find(null), "find should reject null argument");
        System.out.println();
    }

    private static void testSortedListIsImmutable() {
        System.out.println("Test case: sorted list is immutable");
        SearchTree<Integer> tree = new BinarySearchTree<>(List.of(1, 2, 3));
        List<Integer> sortedList = tree.getSortedList();

        assertThrows(() -> sortedList.add(4), "returned sorted list should be immutable");
        System.out.println();
    }

    private static void assertEquals(Object expected, Object actual, String message) {
        if (expected == null ? actual != null : !expected.equals(actual)) {
            throw new AssertionError(message + ". Expected: " + expected + ", actual: " + actual);
        }

        checksPassed++;
        System.out.println("[PASS] " + message + ". Result: " + actual);
    }

    private static void assertThrows(Runnable action, String message) {
        try {
            action.run();
        } catch (IllegalArgumentException | UnsupportedOperationException exception) {
            checksPassed++;
            System.out.println("[PASS] " + message + ". Caught: " + exception.getClass().getSimpleName());
            return;
        }

        throw new AssertionError(message);
    }
}
