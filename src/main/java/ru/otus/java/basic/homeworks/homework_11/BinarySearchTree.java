package ru.otus.java.basic.homeworks.homework_11;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary search tree built from a pre-sorted list.
 *
 * @param <T> tree element type
 */
public class BinarySearchTree<T extends Comparable<? super T>> implements SearchTree<T> {
    private final Node<T> root;

    private static class Node<T> {
        private final T value;
        private Node<T> left;
        private Node<T> right;

        private Node(T value) {
            this.value = value;
        }
    }

    /**
     * Builds a balanced binary search tree from a list sorted in ascending order.
     *
     * @param sortedList source list sorted in ascending order
     * @throws IllegalArgumentException if the list is null, contains null elements,
     *                                  or is not sorted in ascending order
     */
    public BinarySearchTree(List<? extends T> sortedList) {
        if (sortedList == null) {
            throw new IllegalArgumentException("Sorted list must not be null.");
        }

        List<T> elements = new ArrayList<>(sortedList);
        validateElements(elements);
        validateSorted(elements);
        root = buildTree(elements, 0, elements.size() - 1);
    }

    private void validateElements(List<T> elements) {
        for (T element : elements) {
            if (element == null) {
                throw new IllegalArgumentException("Tree elements must not be null.");
            }
        }
    }

    private void validateSorted(List<T> elements) {
        for (int i = 1; i < elements.size(); i++) {
            if (elements.get(i - 1).compareTo(elements.get(i)) > 0) {
                throw new IllegalArgumentException("List must be sorted in ascending order.");
            }
        }
    }

    private Node<T> buildTree(List<T> elements, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }

        int middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        Node<T> node = new Node<>(elements.get(middleIndex));
        node.left = buildTree(elements, leftIndex, middleIndex - 1);
        node.right = buildTree(elements, middleIndex + 1, rightIndex);
        return node;
    }

    @Override
    public T find(T element) {
        if (element == null) {
            throw new IllegalArgumentException("Element must not be null.");
        }

        return find(root, element);
    }

    private T find(Node<T> node, T element) {
        if (node == null) {
            return null;
        }

        int comparisonResult = element.compareTo(node.value);

        if (comparisonResult == 0) {
            return node.value;
        }

        if (comparisonResult < 0) {
            return find(node.left, element);
        }

        return find(node.right, element);
    }

    @Override
    public List<T> getSortedList() {
        List<T> result = new ArrayList<>();
        addInOrder(root, result);
        return List.copyOf(result);
    }

    private void addInOrder(Node<T> node, List<T> result) {
        if (node == null) {
            return;
        }

        addInOrder(node.left, result);
        result.add(node.value);
        addInOrder(node.right, result);
    }
}
