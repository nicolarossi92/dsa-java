package it.mauluk92.dsa.c3.s2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <h1>Array Based Lists</h1>
 * <br/>
 * An obvious choice for implementing the list ADT is to use an array A, where A[i]
 * stores (a reference to) the element with index i. We will begin by assuming
 * that we have a fixed capacity array. An unbound list is known as <strong>array list</strong>
 * in Java.
 */
public class C3S2ArrayBasedListTest {

    /**
     * <h1>ArrayList with fixed capacity</h1>
     * <br/>
     * With a representation based on an array A, the get(i) and set(i, e) methods are
     * easy to implement by accessing A[i] (assuming i is a legitimate index). Methods
     * add(i, e) and remove(i) are more time-consuming, as they require shifting elements
     * up or down to maintain our rule of always storing an element whose list index is i
     * at index i of the array
     */
    @Test
    @DisplayName("ArrayList base impl")
    public void fixedCapacityArrayList(){}

    /**
     * <h1>Performance of a simple array base implementation</h1>
     * <br/>
     * size, get and set clearly run in O(1) time, but insertion and deletion methods
     * can take much longer than this. In particular, add(i,e) runs in time O(n). Indeed, the worst case
     * for this operation occurs when i is 0, since all existing n elements have to be shifted forward.
     * A similar argument applies to  method remove(i), which runs in O(n) time, because we have to shift backward
     * n- 1 elements in the worst case, when i is 0. The average running time is O(n) thus.
     * <br/>
     * <br/>
     * Looking more closely at add(i, e) and remove(i), we note that they each run in time O(n-i + 1), for only
     * those elements at index i and higher have to be shifted up or down. Thus removing or inserting
     * an item at the end of an array list, using the methods add(n,e) and remove(n-1) respectively, takes O(1) time each.
     * <br/>
     * <br/>
     * Moreover, this observation has an interesting consequence for the adaptation of the array list ADT to the deque ADT.
     * If we do the obvious thing and store element of a deque so that the first element is at index 0 and the last
     * element at index n-1, then these methods addLast and removeLast of the deque each run in O(1) time. However,
     * methods addFirst and removeFirst of the deque each run in O(n).
     * We would have to use a circular array implementation to solve this problem and achieve O(1) at insertion an deletion.
     */
    @Test
    @DisplayName("Performance of array base implementation")
    public void performanceOfASimplyArrayImplementation(){}

    /**
     * <h1>Dynamic Arrays</h1>
     * <br/>
     * The implementation provided has a serious limitation; it requires that a fixed
     * maximum capacity be declared, throwing an exception if attempting to add an element
     * once full. This is a major weakness, because if a user is unsure of the maximum size that will
     * be reached for a collection, there is a risk that either too large of an array will be requested,
     * causing an inefficient waste of memory, or that too small of an array will be requested, causing
     * a fatal error when exhausting that capacity.
     * Java {@link java.util.ArrayList} provides a more robust abstraction, allowing a user to add
     * elements to the list, with no apparent limit on the overall capacity. To provide this abstraction, Java
     * relies on an algorithmic sleight of hand that is known as dynamic array.
     * <br/>
     * <br/>
     * In reality, elements of an ArrayList are stored in traditional arrays, and the precise size of that array
     * must be internally declared in order for the system to properly allocate a consecutive piece of memory for its
     * storage.
     * <br/>
     * <br/>
     * The first key to providing the semantics of an unbounded array is that an array list instance
     * maintains an internal array that often has greater capacity than the current length of the list.
     * This extra capacity makes it easy to add a new element to the end of the lists by using the next available
     * cell of the array.
     * <br/>
     * <br/>
     * If a user continues to add elements to a list, all reserved capacity in the underlying array will
     * eventually be exhausted. In that case, the class requests a new, larger array from the system, and
     * copies all references from the smaller array into the beginning of the new array. At that point in time, the old array
     * is no longer needed, so it can be reclaimed by the system.
     * Intuitively, this strategy is much like that of the hermit crab, which moves into a larger shell when it outgrows
     * its previous one.
     */
    @Test
    @DisplayName("Dynamic arrays")
    public void dynamicArrays(){}

    /**
     * <h1>Implementing a Dynamic Array</h1>
     * <br/>
     * The key is to provide means to "grow" the array A, when more space is needed. Of course,
     * we cannot actually grow that array, as its capacity is fixed. Instead, when a call to add a new
     * element risks overflowing the current array, we perform the following additional steps:
     * <ul>
     *     <lI>Allocate a new array B with larger capacity</lI>
     *     <li>Set B[k] = A[k] for k = 0, 1, ... , n-1 where n denotes the current number of items</li>
     *     <li>Set A = B, that is, we henceforth use the new array to support the list</li>
     *     <li>Insert the new element in the new array</li>
     * </ul>
     */
    @Test
    @DisplayName("Implementing dynamic array")
    public void implementingDynamicArray(){}
}
