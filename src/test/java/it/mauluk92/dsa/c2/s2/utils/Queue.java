package it.mauluk92.dsa.c2.s2.utils;

/**
 * Our interface for an ADT Queue
 * @param <T> the type of holding objects
 */
public interface Queue<T> {
    /* Returns the number of elements of a queue */
    int size();
    /* Tests whether the queue is empty */
    boolean isEmpty();
    /* Inserts an element at the rear of the queue */
    void enqueue(T t);
    /* Returns, but does not remove, the first element of the queue ( null if empty). */
    T first();
    /* Removes and returns the first element of the queue (null if empty) */
    T dequeue();
}
