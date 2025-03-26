package it.mauluk92.dsa.c3.s2.utils;

import it.mauluk92.dsa.c3.s1.utils.ListADT;

/**
 * A simple implementation of a fixed capacity ArrayList
 */
public class FixedCapacityArrayList<E> implements ListADT<E> {

    public static final int CAPACITY = 16;
    private final E[] data;
    private int size = 0;

    public FixedCapacityArrayList() {
        this(CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public FixedCapacityArrayList(int capacity){
        data = (E[]) new Object[capacity];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public E get(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        return data[i];
    }

    @Override
    public E set(int i, E e) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        data[i] = e;
        return temp;
    }

    @Override
    public void add(int i, E e) {
        checkIndex(i, size);
        if(size == data.length){
            throw new IllegalStateException("Array is full");
        }
        for(int k = size -  1; k>= 1; k--){
            data[k+1] = data[k];
        }
        data[i] = e;
        size++;
    }

    @Override
    public E remove(int i) throws IndexOutOfBoundsException {
        checkIndex(i, size);
        E temp = data[i];
        for(int k = i; k < size - 1; k++){
            data[k] = data[k+1];
        }
        data[size - 1] = null;
        size--;
        return temp;
    }

    protected void checkIndex(int i, int n) throws IndexOutOfBoundsException {
        if (i < 0 || i>= n){
            throw new IndexOutOfBoundsException("Illegal index: " + i);
        }
    }
}
