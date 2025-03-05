package it.mauluk92.dsa.c2.s1.utils;

import it.mauluk92.dsa.c1.s2.utils.SinglyLinkedList;

/**
 * A simple implementation of a stack using {@link SinglyLinkedList}
 * by means of an Adapter Design Pattern
 * @param <E> the type of objects inside the stack
 */
public class LinkedStack<E> implements StackADT<E> {

    private SinglyLinkedList<E> list = new SinglyLinkedList<>();

    public LinkedStack(){}

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E top() {
        return list.first();
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }
}
