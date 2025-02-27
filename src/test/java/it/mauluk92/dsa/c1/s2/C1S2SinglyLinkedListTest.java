package it.mauluk92.dsa.c1.s2;

import it.mauluk92.dsa.c1.s2.utils.SinglyLinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * Arrays are great for storing things in a certain order, but they have drawbacks.
 * The capacity of the array must be fixed when it is created, and
 * insertions and deletions at interior positions of an array can be time-consuming
 * if many elements must be shifted.
 */
public class C1S2SinglyLinkedListTest {

    /**
     * <h1>Introducing Linked Lists</h1>
     * <br/>
     * We introduce a data structure known as a <strong>linked list</strong>, which provides
     * an alternative to an array-based structure. A linked list, in its simplest form,
     * is a collection of <strong>nodes</strong> that collectively form a linear sequence.
     * In a <strong>singly linked list</strong>, each node stores a reference to an object
     * that is an element of the sequence, as well as a reference to the next node of the list
     * <br/>
     * <br/>
     * <p>
     *     <img src="doc-files/linked_list.svg" alt="Linked List example" width=300, height=150>
     * </p>
     * <br/>
     * A linked list representation relies on the collaboration of many objects. Minimally,
     * the linked list instance must keep a reference of the head node of the list,
     * known as the <strong>head</strong>. Without an explicit reference to the head, there would
     * be no way to locate that node. The last node of the list is known as the <strong>tail</strong>.
     * <br/>
     * <br/>
     * The tail of a list can be found by <strong>traversing</strong> the linked list -
     * starting at the head and moving from one node to another by following the
     * each node's <em>next</em> reference. We can identify the tail as the node having
     * <strong>null</strong> as its <em>next</em> reference.
     * This process is also known as <strong>link hopping</strong> or <strong>pointer hopping</strong>
     * @see SinglyLinkedList
     */
    @Test
    @DisplayName("Introducing Linked Lists")
    public void introducingLinkedList(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        Assertions.assertInstanceOf(SinglyLinkedList.class, list);
    }

    /**
     * <h1>Inserting an Element at the head of a singly linked list</h1>
     * <br/>
     * An important property of a linked list is that it does not have a predetermined fixed size;
     * it uses space proportional to its current number of elements. When using a singly linked list,
     * we can easily insert an element at the head of the list. The main idea is that we create a
     * new node, set its element to the new element, set its next link to refer to the current head, and set
     * the list's head to point to the new node.
     * @see SinglyLinkedList
     */
    @Test
    @DisplayName("Inserting an element at the head of linked list")
    public void insertingElementHeadLinkedList(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        Assertions.assertEquals(1, list.first());
    }

    /**
     * We can also insert an element at the tail of the list, provided we keep a reference
     * to the tail node. In this case, we create a new node, assign its next reference to null,
     * set the next reference of the tail to point to this new node, and then update the tail
     * reference itself to this new node
     * @see SinglyLinkedList
     */
    @Test
    @DisplayName("Inserting an element at the tail of linked list")
    public void insertingElementTailLinkedList(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        list.addLast(2);
        Assertions.assertEquals(2, list.last());
    }

    /**
     * Removing an element from the <strong>head</strong> of a singly linked list is essentially the
     * reverse operation of inserting a new element at the head.
     * Unfortunately, we cannot easily delete the last node of a singly linked list. Even if
     * we maintain a tail reference directly to the last node of the list, we must be able to
     * access <strong>before</strong> the last node in order to remove the last node.
     * But we cannot reach the node before the tail by following next links from the tail.
     * The only way to access this node is to start from the head of the list and search all
     * the way through the list. But such a sequence of link hopping operations could take
     * a long time. If we want to support such an operation efficiently, we'll need to make
     * a list <strong>doubly linked</strong>
     * @see SinglyLinkedList
     */
    @Test
    @DisplayName("Removing an element from a linked list")
    public void removingElementLinkedList(){
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.addFirst(1);
        Assertions.assertEquals(1, list.removeFirst());
        Assertions.assertNull(list.removeFirst());
    }
}
