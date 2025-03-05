package it.mauluk92.dsa.c2.s2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <h1>Queues</h1>
 * <br/>
 * Another fundamental data structure is the <strong>queue</strong>. it is a close
 * cousin of the stack, but a queue is a collection of objects that are inserted and
 * removed according to the <strong>first-in, first-out (FIFO)</strong> principle.
 * That is, elements can be inserted at any given time, but only the element that has
 * been in the queue the longest can be next removed.
 * We usually say that elements enter a queue at the back and are removed from the front.
 */
public class C2S2QueuesTest {

    /**
     * <h1>The Queue Abstract Data Type</h1>
     * <br/>
     * Formally, the que abstract data type defines a collection that keeps objects
     * in a sequence, where element access and deletion are restricted to the <strong>first</strong>
     * element in the queue, and element insertion is restricted to the back of the sequence.
     * This restriction enforces the rule that items are inserted and deleted
     * in a queue according to the first-in, first-out (FIFO) principle.
     * <br/>
     * <ul>
     *     <li>enqueue(e): adds element e to the back of queue</li>
     *     <li>dequeue(): removes and returns the first element from the queue</li>
     * </ul>
     * The queue ADT also includes the following accessor methods:
     * <ul>
     *     <li>first(): Returns the first element of queue, without removing it</li>
     *     <li>size(): Returns the number of elements in the queue</li>
     *     <li>isEmpty(): Returns a boolean indicating whether the queue is empty</li>
     * </ul>
     * By convention, we assume that elements added to the queue can have arbitrary type
     * and that a newly created queue is empty. We formalize the que ADT with the Java interface.
     */
    @Test
    @DisplayName("The Queue ADT")
    public void queueADT(){}

    /**
     * <h1>The java.util.Queue interface in Java</h1>
     * <br/>
     * Java provides a type of queue interface, {@link java.util.Queue} which has
     * functionality similar to the traditional queue ADT.
     * Queue supports two styles for most operations, which vary in the way that they treat exceptional
     * cases. When a queue is empty, the remove() and element() methods throw a {@link java.util.NoSuchElementException},
     * while the corresponding method poll() and peek() return null. For implementations with
     * a bounded capacity, the add method will throw an {@link IllegalStateException} when full,
     * while the offer method ignores the new element and returns false to signal
     * the element was not accepted.
     */
    @Test
    @DisplayName("Queue interface in Java")
    public void queueInterfaceJava(){}

    /**
     * <h1>Array Based Queue</h1>
     * <br/>
     * Let's assume that as elements are inserted into a queue, we store them in an
     * array such that the first element is at index 0, the second element at index 1,
     * and so on. With such an implementation the question is how we should implement
     * the dequeue operation. The element to be removed is stored at index 0 of the array.
     * Our strategy is to execute a loop to shift all other elements of the queue one cell
     * to the left, so that the front of the queue is again aligned with cell 0 of the array.
     * Unfortunately, the use of such a loop would result in an O(n) running time for the
     * dequeue method.
     * <br/>
     * <br/>
     * We can improve our strategy to avoid the loop completely. We will replaced a dequeued element in the
     * array with a null reference, and maintain an explicit f to represent the index of the element
     * that is currently at the front of the queue. Such an algorithm for dequeue would run in O(1)
     * time. However, there remain a challenge with the revised approach. With an array
     * of capacity N, we should be able to store up to N elements before reaching any
     * exceptional case. If we repeatedly let the front of the queue drift rightward over time,
     * the back of the queue would reach the end of the underlying array even when
     * there are a fewer than N elements currently in the queue. We must decide how to store
     * additional elements in such a configuration.
     **/
    @Test
    @DisplayName("Array based queue")
    public void arrayBasedQueue(){}
}
