package ru.otus.java.basic.homeworks.homework_11;

import java.util.List;

public interface SearchTree<T> {
    /**
     * Finds the specified element in the tree.
     *
     * @param element element to find
     * @return found element if it exists, otherwise null
     */
    T find(T element);

    /**
     * Returns all tree elements in sorted order.
     *
     * @return sorted list of tree elements
     */
    List<T> getSortedList();
}
