package it.mauluk92.dsa.c2.s1.utils;

/**
 * An array based implementation of stack
 * @param <E> the type of element inside the stack itself
 */
public class ArrayStack<E> implements StackADT<E> {

    public static final int CAPACITY = 1000;                // Default array capacity
    private E[] data;                                       // Generic array used for storage
    private int t = -1;                                     // index of top element of stack
    public ArrayStack() {                                   // Constructs stack with default capacity
        this(CAPACITY);
    }
    @SuppressWarnings("unchecked")
    public ArrayStack(int capacity){                        // Constructs stack with given capacity
        data = (E[]) new Object[capacity];                  // Safe cast
    }

    @Override
    public int size() {
        return t + 1;
    }

    @Override
    public boolean isEmpty() {
        return t == -1;
    }

    @Override
    public void push(E e) {
        if(size() == data.length){
            throw new IllegalStateException();
        }
        data[++t] = e;                                      // increment before storing new item
    }

    @Override
    public E top() {
        if(isEmpty()){
            return null;
        }
        return data[t];
    }

    @Override
    public E pop() {
        if(isEmpty()){
            return null;
        }
        E answer = data[t];
        data[t] = null;                                     // deference to help garbage collector
        t--;
        return answer;
    }
}
