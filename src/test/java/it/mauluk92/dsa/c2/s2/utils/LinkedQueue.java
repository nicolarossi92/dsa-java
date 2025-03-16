package it.mauluk92.dsa.c2.s2.utils;

import it.mauluk92.dsa.c1.s2.utils.SinglyLinkedList;

/**
 * Realization of a FIFO queue as an adaptation of a SinglyLinkedList
 * @param <T> The type of object to hold
 */
public class LinkedQueue<T> implements Queue<T> {

    private final SinglyLinkedList<T> list = new SinglyLinkedList<>();

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void enqueue(T t) {
        list.addLast(t);
    }

    @Override
    public T first() {
        return list.first();
    }

    @Override
    public T dequeue() {
        return list.removeFirst();
    }
}
