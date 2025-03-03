package it.mauluk92.dsa.c1.s5;

import it.mauluk92.dsa.c1.s5.utils.LinkedListUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import it.mauluk92.dsa.c1.s2.utils.SinglyLinkedList;

/**
 * <h1>Testing for equality</h1>
 * <br/>
 * When working with reference types, there are many different notions of what
 * it means to one expression to be equal to another. At the lowest level,
 * if a and b are reference variables, then expression a == b tests whether a and b refer
 * to the same object (or if both are set to the null value).
 * <br/>
 * <br/>
 * However, for many types there is a higher level notion of two variables
 * being considered equivalent even if they do not actually refer to the same
 * instance of the class. For example, we typically want to consider two String instances
 * to be equivalent to each other if they represent the identical sequence of characters.
 * <br/>
 * <br/>
 * To support a broader notion of equivalence, all object types support a method
 * named <strong>equals</strong>. Users of reference types should rely on the syntax
 * a.equals(b), unless they have a specific need to test the more narrow notion
 * of identity. The equals method is formally defined in the {@link Object} class,
 * which serves as a superclass for all reference types, but that implementation reverts
 * to returning the value of expression a == b. Defining a more meaningful notion of
 * equivalence requires knowledge about a class and its representation
 */
public class C1S5TestingForEqualityTest {


    /**
     * <h1>Equivalence relationship</h1>
     * <br/>
     * The author of each class has a responsibility to provide an implementation of
     * the equals method, which overrides the one inherited by Object, if there is
     * a more relevant definition for the equivalence of two instances.
     * Great care must be taken when overriding the notion of equality, as the consistency of
     * Java's libraries depends upon the equals method defining what is known as an
     * <strong>equivalence relation</strong> in mathematics, satisfying the following
     * properties.
     * <ul>
     *     <li>
     *         <strong>Treatment of null</strong>: for any non null reference variable x, the call
     *         x.equals(null) should return false (nothing equals null except null itself).
     *     </li>
     *     <li>
     *         <strong>Reflexivity:</strong> for any non null reference variable x, the call
     *         x.equals(x) should return true (an object is equal to itself).
     *     </li>
     *     <li>
     *         <strong>Symmetry:</strong> for any non null reference variables x and y, the calls
     *         x.equals(y) and y.equals(x) should return the same value.
     *     </li>
     *     <li>
     *         <strong>Transitivity:</strong> for any non null reference variables x,y, and z, if
     *         both calls x.equals(y) and y.equals(z) return true, then call x.equals(z)
     *         must return true as well.
     *     </li>
     * </ul>
     */
    @Test
    @DisplayName("Relation of equivalence")
    public void relationOfEquivalence(){}

    /**
     * <h1>Equivalence testing with arrays</h1>
     * <br/>
     * Arrays are a reference type in Java, but not technically a class.
     * However, the {@link java.util.Arrays} class provides additional
     * static method that are useful when processing arrays.
     * <ul>
     *     <li>a==b tests if a and b refer to the same underlying array instance</li>
     *     <li>
     *         a.equals(b). This is identical to a==b. Arrays are not a true class type and do not
     *         override the Object.equals() method.
     *     </li>
     *     <li>
     *         Arrays.equals(a,b): this provides a more intuitive notion of equivalence,
     *         returning true if the arrays have the same length and all pairs
     *         of corresponding elements are equal to each other, so that primitives
     *         are confronted with == and reference type with equals method of Object.
     *     </li>
     * </ul>
     * Arrays.equals captures the appropriate notion of equivalence.
     */
    @Test
    @DisplayName("Equivalence testing with arrays")
    public void equivalenceTestingWithArrays(){
        int[] a = {1, 2 ,3};
        int[] b = {1, 2, 3};

        Assertions.assertArrayEquals(a, b);
    }

    /**
     * <h1>Equivalence Testing with Linked Lists</h1>
     * <br/>
     * We develop an implementation of the equals method in the context
     * of {@link SinglyLinkedList}. Using a definition very similar to the treatment of arrays
     * by the equals method of {@link java.util.Arrays}, we consider two lists to be equivalent
     * if they have the same length and contents that are element-by-element
     * equivalent. We can evaluate such equivalence by simultaneously traversing two lists,
     * verifying that x.equals(y) for each pair of corresponding elements x and y.
     * We take a conservative approach, demanding that two objects be instances of the the same
     * class to have any possibility of equivalence.
     * @see LinkedListUtils
     */
    @Test
    @DisplayName("Equivalence testing with linked list")
    public void equivalenceLinkedLists(){
        SinglyLinkedList<Integer> first  = new SinglyLinkedList<>();
        first.addFirst(0);
        first.addFirst(1);
        first.addFirst(2);

        SinglyLinkedList<Integer> second = new SinglyLinkedList<>();
        second.addFirst(0);
        second.addFirst(1);
        second.addFirst(2);

        Assertions.assertTrue(LinkedListUtils.equals(first, second));
    }
}
