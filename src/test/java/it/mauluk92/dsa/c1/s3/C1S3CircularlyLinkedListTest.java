package it.mauluk92.dsa.c1.s3;

import it.mauluk92.dsa.c1.s3.utils.CircularlyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Linked lists are traditionally viewed as storing a sequence of items in a
 * linear order, from first to last. However, there are many applications in
 * which data can be more naturally view as having a <strong>cyclic order</strong>, with well-defined
 * neighboring relationship, but no fixed beginning or end.
 */
public class C1S3CircularlyLinkedListTest {

    /**
     * <h1>Round-Robin Scheduling</h1>
     * <br/>
     * One of the most important roles of an operating system is in managing the many processes
     * that are currently active on a computer, including the scheduling of those
     * processes on one or more central processing units (CPUs). In order
     * to support the responsiveness of an arbitrary number of concurrent processes,
     * most operating systems allow processes to effectively share use of the CPUs,
     * using some form of an algorithm known as <strong>round-robin scheduling</strong>.
     * <br/>
     * <br/>
     * A process is given a short turn to execute, known as <strong>time slice</strong>, but it is interrupted
     * when the slice ends, even if its job is not yet complete.
     * Each active process is given its own time slice, taking turns in a cyclic order.
     * New processes can be added to the system, and processes that complete their work
     * can be removed.
     * <br/>
     * <br/>
     * Unfortunately, there are drawbacks to the use of a traditional linked list for this
     * purpose. It is unnecessarily inefficient to repeatedly throw away a node from the
     * end of the list, only to create a new node for the same element when reinserting it,
     * not to mention the various updates that are performed to decrement
     * and increment the list's size to unlink and relink nodes.
     * @see CircularlyLinkedList
     */
    @Test
    @DisplayName("Round robin scheduling")
    public void roundRobinScheduling(){
        CircularlyLinkedList<Integer> circularlyLinkedList = new CircularlyLinkedList<>();
        Assertions.assertInstanceOf(CircularlyLinkedList.class, circularlyLinkedList);
    }

    /**
     * <h1>Designing Circularly Linked List</h1>
     * <br/>
     * We design a structure known as a <strong>circularly linked list</strong>, which is
     * essentially a singularly linked list in which the next reference of the tail node is set
     * to refer back ot the head of the list (rather than <strong>null</strong>) as shown.
     * We use this model to design and implement a new CircularlyLinkedList class,
     * which supports all the public behaviors of our SinglyLinkedList class and one additional
     * update method: rotate(), which moves the first element to the end of the list.
     * With this new operation, round-robin scheduling can be efficiently implemented by repeatedly
     * the following steps on a circularly linked list C:
     * <ol>
     *     <li>Give a time slice to process C.first()</li>
     *     <li>C.rotate()</li>
     * </ol>
     * @see CircularlyLinkedList
     */
    @Test
    @DisplayName("Designing circularly linked list")
    public void designingCircularlyLinkedList(){
        CircularlyLinkedList<Integer> circularlyLinkedList = new CircularlyLinkedList<>();
        Assertions.assertInstanceOf(CircularlyLinkedList.class, circularlyLinkedList);
    }

    /**
     * <h1>Operations on circularly linked list</h1>
     * <br/>
     * Implementing the new rotate method is quite trivial. We do not move any nodes or elements,
     * we simply advance the tail reference to point to the node that follows it.
     * We can add a new element at the front of the list by creating a new node and
     * linking it just after the tail of the list. To implement the addLast() method, we can rely
     * on the use of a call to addFirst() and then immediately advance the tail reference so that
     * the newest node becomes the last. Removing the first node from a circularly linked list
     * can be accomplished by simply updating the next field of the tail node to bypass the
     * implicit head.
     * @see CircularlyLinkedList
     */
    @Test
    @DisplayName("Operations on circularly linked list")
    public void operationsCircularlyLinkedList(){
        CircularlyLinkedList<Integer> circularlyLinkedList = new CircularlyLinkedList<>();
        circularlyLinkedList.addFirst(1);
        circularlyLinkedList.addFirst(2);
        circularlyLinkedList.addFirst(3);

        Assertions.assertEquals(3, circularlyLinkedList.first());
        circularlyLinkedList.rotate();
        Assertions.assertEquals(2, circularlyLinkedList.first());
        circularlyLinkedList.rotate();
        Assertions.assertEquals(1, circularlyLinkedList.first());
    }
}
