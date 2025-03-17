package it.mauluk92.dsa.c2.s3;

import it.mauluk92.dsa.c2.s3.utils.ArrayBasedDeque;
import it.mauluk92.dsa.c2.s3.utils.Deque;
import it.mauluk92.dsa.c2.s3.utils.DoublyLinkedDeque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.mauluk92.dsa.c2.s2.utils.ArrayBasedQueue;
import it.mauluk92.dsa.c1.s4.utils.DoublyLinkedList;

/**
 * We next consider a queue-like data structure that supports insertion and deletion
 * at both the front end and the back of the queue. Such a structure is called
 * a <strong>double-ended queue</strong>. The deque abstract data type is more general
 * than both the stack and the queue ADTs. The extra generality can be useful in some
 * applications. For example, we described a restaurant using a queue only to find that
 * a table was not available; typically the restaurant will reinsert the person at the first
 * position in the queue. It may also be that a customer at the end of the queue may grow
 * impatient and leave the restaurant.
 */
public class C2S3DoubleEndedQueuesTest {


    /**
     * The deque abstract data type is richer than both the stack and the queue ADTs.
     * To provide a symmetrical abstraction, the deque ADT is defined to support
     * the following update methods:
     * <ul>
     *     <li>addFirst(e): Insert a new element e at the front of the deque</li>
     *     <li>addLast(e): Insert a new element e at the back of the deque</li>
     *     <li>removeFirst(): Remove and return the first element of the deque</li>
     *     <li>removeLast(): Remove and return the last element of the deque</li>
     * </ul>
     * Additionally, the deque ADT will include the following accessors:
     * <ul>
     *     <li>first(): Returns the first element of the deque, without removing it</li>
     *     <li>last(): Returns the last element of the deque, without removing it</li>
     *     <li>size(): Returns the number of elements in the deque</li>
     *     <li>isEmpty(): Returns a boolean indicating whether the deque is empty</li>
     * </ul>
     */
    @Test
    @DisplayName("Deque ADT")
    public void dequeAdt(){}

    /**
     * If using an array, we recommend a representation to the {@link ArrayBasedQueue} class,
     * treating the array in circular fashion and storing the index of the first element
     * and the current size of the deque as fields; the index of the last element can be calculated,
     * as needed, using modular arithmetic.
     * One extra concern is avoiding use of negative values with the modulo operator.
     * When removing the first element, the front index is advanced in circular fashion,
     * with the assignment f = (f + 1) % N. But when an element is inserted at the front,
     * the first index must effectively be decremented in circular fashion, and it is a mistake
     * to assign f = (f - 1 ) % N. The problem is that when f is 0, the goal should be
     * to decrement it to other end of the array, and thus to index N - 1.
     * A standard way to decrement an index circularly is instead to assign f = ( f -1 + N) % N.
     * Thus ensuring the positive value.
     */
    @Test
    @DisplayName("Circular array deque")
    public void circularArrayBasedDeque(){
        Deque<Integer> deque = new ArrayBasedDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);

        Assertions.assertEquals(3, deque.first());
        Assertions.assertEquals(2, deque.last());
        Assertions.assertEquals(3, deque.removeFirst());
        Assertions.assertEquals(2, deque.removeLast());
        Assertions.assertEquals(1, deque.removeLast());
    }

    /**
     * Because deque requires insertion and removal at both ends, a doubly linked
     * list is most appropriate for implementing all operations efficiently. In fact,
     * the {@link DoublyLinkedList} already implements the entire {@link Deque} interface;
     * we simply need to add the declaration  "implements Deque" to that class definition
     * in order to use it as a deque.
     */
    @Test
    @DisplayName("Doubly linked list deque")
    public void doublyLinkedListDeque(){
        Deque<Integer> deque = new DoublyLinkedDeque<>();
        deque.addFirst(1);
        deque.addLast(2);
        deque.addFirst(3);

        Assertions.assertEquals(3, deque.first());
        Assertions.assertEquals(2, deque.last());
        Assertions.assertEquals(3, deque.removeFirst());
        Assertions.assertEquals(2, deque.removeLast());
        Assertions.assertEquals(1, deque.removeLast());
    }
}
