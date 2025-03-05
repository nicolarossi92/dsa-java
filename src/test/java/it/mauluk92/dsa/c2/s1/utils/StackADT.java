package it.mauluk92.dsa.c2.s1.utils;

/**
 * A collection of objects that are inserted and removed according to the last-in
 * first-out principle. Although similar in purpose, this interface differs from
 * {@link java.util.Stack}
 * @param <T> The type of objects inside the stack
 */
public interface StackADT<T> {

    /**
     * Returns the number of elements in the stack
     * @return number of elements in the stack
     */
    int size();

    /**
     * Tests whether the stack is empty
     * @return true if the stack is empty, false otherwise
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack
     * @param t the element to be inserted
     */
    void push(T t);

    /**
     * Returns, but not remove, the element at the top of the stack
     * @return top element in the stack (or null if empty)
     */
    T top();

    /**
     * Removes and returns the top element from the stack.
     * @return element removed (or null, if empty)
     */
    T pop();
}
