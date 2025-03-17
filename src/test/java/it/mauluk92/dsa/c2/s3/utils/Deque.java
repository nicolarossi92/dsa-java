package it.mauluk92.dsa.c2.s3.utils;

/**
 * Interface for a double ended queue: a collection of elements that can be inserted
 * and removed at both ends; this interface is a simplified versionof {@link java.util.Deque}
 * @param <T> the type of object to hold in the deque
 */
public interface Deque<T> {

    /* Returns the number of elements in the deque */
    int size();
    /* Tests whether the deque is empty */
    boolean isEmpty();
    /* Returns, but does not remove, the first element of the deque (null if empty) */
    T first();
    /* Returns, but does not remove, the last element of the deque (null if empty) */
    T last();
    /* Inserts an element at the front of the deque */
    void addFirst(T e);
    /* Inserts an element at the back of the deque */
    void addLast(T e);
    /* Removes and returns the first element of the deque (null if empty) */
    T removeFirst();
    /* Removes and returns the last element of the deque (null if empty) */
    T removeLast();
}
