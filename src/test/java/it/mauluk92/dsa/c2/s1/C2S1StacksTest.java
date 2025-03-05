package it.mauluk92.dsa.c2.s1;

import it.mauluk92.dsa.c2.s1.utils.ArrayStack;
import it.mauluk92.dsa.c2.s1.utils.LinkedStack;
import it.mauluk92.dsa.c2.s1.utils.StackADT;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <h1>Stacks</h1>
 * <br/>
 * A <strong>stack</strong> is a collection of objects that are inserted
 * and removed according to the <strong>last-in, first-out (LIFO)</strong> principle.
 * A user may insert objects into a stack at any given time, but may only access
 * or remove the most recently inserted object that remains
 * (at the "top" of the stack). The name stack is derived from the metaphor
 * of a stack of plates in a spring-loaded, cafeteria plate dispenser.
 * Stacks are a fundamental data structure, they are used in many applications
 */
public class C2S1StacksTest {

    /**
     * <h1>The Stack Abstract Data Type</h1>
     * <br/>
     * Stacks are the simplest of all data structures, yet they are also among
     * the most important, as they are used in a host of different applications,
     * and as a tool for many more sophisticated data structures and algorithms. Formally, a stack
     * is an abstract data type (ADT) that supports the following two update methods:
     * <ul>
     *     <li>push(e): Adds element to the top of the stack</li>
     *     <li>pop(): Removes and returns the top element from the stack</li>
     * </ul>
     * Additionally, a stack supports the following accessor methods for convenience:
     * <ul>
     *     <li>top(): Returns the top element of the stack, without removing it</li>
     *     <li>size(): Returns the number of elements in the stack</li>
     *     <li>isEmpty(): Returns a boolean indicating whether the stack is empty</li>
     * </ul>
     */
    @Test
    @DisplayName("Stack ADT")
    public void stackADT(){}

    /**
     * <h1>Stack interface in Java</h1>
     * <br/>
     * In order to formalize our abstraction of a stack, we define what is known as its
     * <strong>application programming interface (API)</strong> in the form of a Java
     * interface, which describes the names of methods that the ADT supports and how they are
     * to be declared and used.
     * @see StackADT
     */
    @Test
    @DisplayName("Stack interface in Java")
    public void stackInterface(){}

    /**
     * <h1>Java Stack in java.util</h1>
     * <br/>
     * Because of the importance of the stack ADT, Java has included since its original
     * version, a concrete class named {@link java.util.Stack}  that implements the LIFO
     * semantics of stack. LIFO functionality is provided by a more general data structure
     * known as double ended queue.
     */
    @Test
    @DisplayName("The java.util.Stack class")
    public void javaOriginalStack(){}

    /**
     * <h1>Array based implementation of stack</h1>
     * <br/>
     * We store elements in an array, named data, which capacity N for some fixed N. We oriented the stack so that
     * the bottom element of the stack is always stored in cell data[0], and the top element
     * of stack is in cell data[t], where t is equal to the last index element.
     * @see ArrayStack
     */
    @Test
    @DisplayName("Simple Array base Stack implementation")
    public void arrayStack(){
        Assertions.assertInstanceOf(StackADT.class, new ArrayStack<>());
    }

    /**
     * <h1>Drawbacks array based stack implementation</h1>
     * <br/>
     * The array implementation of a stack is simple and efficient. Nevertheless, this
     * implementation has one negative aspect: it relies on a fixed capacity array, which limits
     * the ultimate size of the stack.
     * For convenience, we allow the user of the stack to specify the capacity as a parameter to
     * the constructor. In cases where a user has a good estimate on the number of items
     * needing to go in the stack, the array based implementation is hard to beat. However,
     * if the estimate is wrong, there can be grave consequences. Thus, even with its simplicity
     * and efficiency, the array based stack implementation is not necessarily ideal.
     */
    @Test
    @DisplayName("A drawback of this array-based stack impl")
    public void drawbackArrayStack(){}

    /**
     * <h1>Analysis of Array based implementation of Stack</h1>
     * <br/>
     * Each method of the stack executes a constant number of statements involving
     * arithmetic operations, comparisons, and assignments, or calls to size() and
     * isEmpty(), which both run in constant time. Thus, in this implementation of the stack
     * ADT, each method runs in constant time, that is, they each run in O(1) time.
     */
    @Test
    @DisplayName("Analysis array based implementation of Stack")
    public void analysisArrayStack(){}

    /**
     * <h1>Implementing a Stack with a singly linked list</h1>
     * <br/>
     * The stack can be implemented using a singly linked list as a storage.
     * Unlike our array-based implementation, the linked list approach has memory usage that is always
     * proportional to the number of actual elements currently in the stack, and without an arbitrary
     * capacity limit. In designing such an implementation, we need to decide if the top of
     * the stack is at the front or back of the list. There is clearly a best choice here, however, since
     * we can insert and delete elements in constant time only at the front.
     * With the top of the stack stored at the front of the list, all methods execute in constant
     * time.
     * <br/>
     * <br/>
     * <h2>The Adapter Pattern</h2>
     * <br/>
     * The adapter design pattern applies to any context where we effectively want to modify existing class
     * so that its methods match those those of a related, but different, class or interface.
     * One general way to apply the adapter pattern is to define a new field, and then
     * to implement each method of the new class using methods of this hidden instance variable.
     * By applying the adapter design pattern in this way, we have created a new class that performs
     * some of the same functions as an existing class, but repackaged in a more convenient way.
     * @see LinkedStack
     */
    @Test
    @DisplayName("Linked List based stack")
    public void linkedListBasedStack(){
        Assertions.assertInstanceOf(StackADT.class, new LinkedStack<>());
    }


}
