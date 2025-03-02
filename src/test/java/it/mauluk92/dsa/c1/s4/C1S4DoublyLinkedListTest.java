package it.mauluk92.dsa.c1.s4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <h1>Doubly Linked Lists</h1>
 * <br/>
 * In a singly linked list, each node maintains a reference to the node that is
 * immediately after it. However, there are limitations that stem from
 * the asymmetry of a singly linked list. More generally, we cannot efficiently
 * delete an arbitrary node from an interior position of the list if only given
 * a reference to that node, because we cannot determine the node that immediately
 * precedes the node to be deleted (yet, that node needs have its next reference updated).
 * To provide greater symmetry, we define a linked list in which each node keeps
 * an explicit reference to the node before it and a reference to the node after it.
 * Such a structure is known as a <strong>doubly linked list</strong>. These lists
 * allow a greater variety of O(1)-time update operations, including insertions and
 * deletions at arbitrary positions within the test
 */
public class C1S4DoublyLinkedListTest {

    /**
     * <h1>Header and Trailer Sentinels</h1>
     * <br/>
     * In order to avoid some special cases when operating near the boundaries
     * of a doubly linked list, it helps to add special nodes at both ends of the list:
     * a <strong>header</strong> node at the beginning of the list, and a <strong>trailer</strong>
     * node at the end of the list. These <em>dummy nodes</em> are known as <strong>sentinels</strong>
     * (or guards), and they do not store elements of the primary sequence.
     * <br/>
     * <br/>
     * When using sentinels nodes, an empty list is initialized so that the next field
     * of the header points to the trailer, and the prev field of the trailer points to
     * the header; the remaining fields of the sentinels are irrelevant (presumably null).
     * For a non empty list, the header's next will refer to a node containing first real
     * element of a sequence, just the trailer's prev references the node containing the last
     * element of a sequence.
     */
    @Test
    @DisplayName("Header and Trailer Sentinels")
    public void headerAndTrailerSentinels(){}

    /**
     * <h1>Advantage of Using Sentinels</h1>
     * <br/>
     * Although we could implement in a doubly linked list without sentinel nodes, the slight
     * extra memory devoted to the sentinels greatly simplifies the logic of our operations. Most
     * notably, the header and trailer nodes never changes - only the nodes between them change.
     * <br/>
     * <br/>
     * Furthermore, we can treat all insertions in a unified manner, because a new node will always
     * be placed between a pair of existing nodes. In similar fashion, every element that is
     * to be deleted is guaranteed to be stored in a node that has neighbors on each side.
     */
    @Test
    @DisplayName("Advantage of Sentinels")
    public void advantageOfSentinels(){}

    /**
     * <h1>Operations on doubly linked list</h1>
     * <br/>
     * Every insertion into our doubly linked list representation will take place
     * between a pair of existing nodes. For example, when a new node element
     * is inserted at the front of the sequence, we will simply add the new node between
     * the header and the node that is currently after the header.
     * The deletion proceeds in the opposite fashion of an insertion.
     * <br/>
     * <br/>
     * The two neighbors of the node to be deleted are linked directly to each other, thereby
     * bypassing the original node. As a result, that node will no longer considered
     * part of the list and it can be reclaimed by the system. Because
     * of our use of sentinels, the same implementation can be used when deleting
     * the first or the last of a sequence, because even such an element will be stored
     * at a node that lies between two others.
     */
    @Test
    @DisplayName("Operations on a doubly linked list")
    public void operationsOnDoublyLinkedList(){}


}
