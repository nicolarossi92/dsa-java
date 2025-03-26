package it.mauluk92.dsa.c3.s1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <h1>The List ADT</h1>
 * <br/>
 * In this chapter, we explore several abstract data types that represents a linear
 * sequence of elements, but with more general support for adding or removing elements
 * at arbitrary positions. However, designing a single abstraction that is well suited
 * for efficient implementation with either an array or a linked list is challenging,
 * given the very different nature of these two fundamental data structures.
 * Locations within an array are easily described with an integer index.
 */
public class C3S1TheListADTTest {

    /**
     * <h1>Java List</h1>
     * <br/>
     * Java defines a general interface, {@link java.util.List}, that includes the following
     * index-based method:
     * <ul>
     *     <li>size(): return the number of elements in the list</li>
     *     <li>isEmpty(): returns a boolean indicating whether the list is empty</li>
     *     <li>
     *         get(i): returns the element of the list having index i; an error condition
     *         occurs if i is not in range
     *     </li>
     *     <li>
     *         set(i, e): replaces the element at index i with e, and returns the old element
     *         that was replaced; an error condition occurs if i is not in range
     *     </li>
     *     <li>
     *         add(i, e): inserts a new element e into the list so that it has index i,
     *         moving all subsequent elements one index later in the list; an error
     *         condition occurs if i is not in range
     *     </li>
     *     <li>
     *         remove(i, e): removes and returns the element at index i, moving all subsequent
     *         elements one index earlier in the list; an error condition occurs if i is not in range
     *     </li>
     * </ul>
     */
    @Test
    @DisplayName("Java List ADT")
    public void javaListADT(){}
}
