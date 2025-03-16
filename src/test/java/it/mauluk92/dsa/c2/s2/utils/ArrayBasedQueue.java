package it.mauluk92.dsa.c2.s2.utils;

/**
 * Implementation of the queue ADT using a fixed array length for storage
 * @param <T> The type of object hold by the queue
 */
public class ArrayBasedQueue<T> implements Queue<T> {

    private static final int CAPACITY = 100;
    private final T[] data;                        // generic array used for storage
    private int f = 0;                       // index of the front element
    private int sz = 0;                      // current number of elements

    public ArrayBasedQueue(){
        this(CAPACITY);                       // constructs a queue with default capacity
    }
    @SuppressWarnings("unchecked")
    public ArrayBasedQueue(int capacity){
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
    public void enqueue(T t) throws IllegalStateException {
        if (sz == data.length){
            throw new IllegalStateException("Queue is full");
        }
        int avail = (f + sz) % data.length;
        data[avail] = t;
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
    public T dequeue() {
        if(isEmpty()){
            return null;
        }
        T answer = data[f];
        f = (f + 1) % data.length;
        sz--;
        return answer;
    }
}
