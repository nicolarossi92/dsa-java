package it.mauluk92.dsa.c2.s3.utils;

/**
 * Simple implementation of a circular array based deque
 * @param <T> the type of object to hold inside the deque
 */
public class ArrayBasedDeque<T> implements Deque<T>{

    private static final int CAPACITY = 100;
    private final T[] data;                        // generic array used for storage
    private int f = 0;                       // index of the front element
    private int sz = 0;                      // current number of elements

    public ArrayBasedDeque(){
        this(CAPACITY);                       // constructs a queue with default capacity
    }
    @SuppressWarnings("unchecked")
    public ArrayBasedDeque(int capacity){
        data = (T[]) new Object[capacity];     // constructs a queue with given capacity
    }

    /* Returns the number of elements inside a queue */
    @Override
    public int size() {
        return sz;
    }
    /* Tests whether the queue is empty */
    @Override
    public boolean isEmpty() {
        return sz == 0;
    }

    /* Inserts an element at the rear of the queue */
    @Override
    public void addFirst(T t) throws IllegalStateException {
        if (sz == data.length){
            throw new IllegalStateException("Queue is full");
        }
        f = (f -1 + data.length) % data.length;
        data[f] = t;
        sz++;
    }

    /* Returns, but does not remove, the first element of the queue (null if empty) */
    @Override
    public T first() {
        if(isEmpty()){
            return null;
        }
        return data[f];
    }

    /* Removes and returns the first element of the queue (null if empty) */
    @Override
    public T removeFirst() {
        if(isEmpty()){
            return null;
        }
        T answer = data[f];
        data[f] = null;
        sz--;
        return answer;
    }

    @Override
    public T last() {
        if(isEmpty()){
            return null;
        }
        return data[(f + data.length + sz -1) % data.length];
    }

    @Override
    public void addLast(T e) throws IllegalStateException {
        if (sz == data.length){
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + data.length + sz) % data.length;
        data[avail] = e;
        sz++;
    }

    @Override
    public T removeLast() {
        if(isEmpty()){
            return null;
        }
        int avail = (f + sz + data.length) % data.length;
        T answer = data[avail];
        data[avail] = null;
        sz--;
        return answer;
    }
}
