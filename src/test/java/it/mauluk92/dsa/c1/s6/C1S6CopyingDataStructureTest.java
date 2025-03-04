package it.mauluk92.dsa.c1.s6;

import it.mauluk92.dsa.c1.s2.utils.SinglyLinkedList;
import it.mauluk92.dsa.c1.s5.utils.LinkedListUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <h1>Copying Data Structures</h1>
 * <br/>
 * The beauty of object-oriented programming is that abstraction allows for a data
 * structure to be treated as a single object, even though the encapsulated implementation
 * of this structure might rely on a more complex combination of many objects.
 * <br/>
 * <br/>
 * In a programming environment, a common expectation is that a copy of an object has
 * its own state and that, once made, the copy is independent of the original.
 * However, when objects have fields that are reference variables pointing to auxiliary objects,
 * it is not always obvious whether a copy should have a corresponding field that refers
 * to the same auxiliary object, or to a new copy of the auxiliary object.
 * <br/>
 * <br/>
 * There is no one-size-fits all answer to questions like this. Instead, each
 * class in Java is responsible for defining whether its instances can be copied,
 * and if so, precisely how the copy is constructed. The universal {@link Object}
 * superclass defines a method named <strong>clone</strong>, which can be used to
 * produce what is known as a <strong>shallow copy</strong> of an object.
 * <br/>
 * <br/>
 * A shallow copy is not always appropriate for all classes, and therefore, Java
 * intentionally disables the clone() method by declaring it as protected, by
 * having it throw a {@link CloneNotSupportedException} when called.
 * The author of a class must explicitly declare support for cloning by formally
 * declaring a public version of the clone() method. That public method can simply call the protected one
 * to do the field by field assignment that results in a shallow copy, if appropriate
 */
public class C1S6CopyingDataStructureTest {

    /**
     * <h1>Cloning Arrays</h1>
     * <br/>
     * <br/>
     * Although arrays support some special syntax such as a[k] and a.length, it is
     * important to remember that they are objects, and that array variables are reference
     * variables. This has important consequences. This has important consequences
     * You should clone element-wise during the cloning of an array
     */
    @Test
    @DisplayName("Cloning Arrays")
    public void cloningArrays(){
        // Arrays of primitive values
        int[] arraysOfPrimitives = {1, 2 ,3};
        int[] clonedArrayOfPrimitives = arraysOfPrimitives.clone(); // This result in an independent array
        clonedArrayOfPrimitives[0] = 7; // modifying independent array

        // Now creating an array of reference variables
        Person first = new Person();
        first.setName("Nicola");
        first.setSurname("Rossi");

        Person second = new Person();
        second.setName("Mario");
        second.setSurname("Rossi");

        Person[] contacts = {first, second};

        // Making a shallow copy by using array clone method()
        Person[] shallowCopy = contacts.clone();

        // Altering first object
        shallowCopy[0].setName("Marco"); // This propagates to our first object with name "Nicola"

        // Deep copy using cloneable interface
        Person[] deepCopy = new Person[contacts.length];
        for(int k = 0; k < contacts.length; k++){
            deepCopy[k] = contacts[k].clone(); // Making a deep copy
        }

        // Attempt to modify second object

        deepCopy[1].setSurname("Bianchi"); // This will not propagate to second object in array

        Assertions.assertNotEquals(arraysOfPrimitives, clonedArrayOfPrimitives); // Arrays of primitives are cloned correctly
        Assertions.assertEquals("Marco", first.getName()); // Shallow copy
        Assertions.assertNotEquals(contacts[1].getSurname(), deepCopy[1].getSurname()); // Unaffected copy
    }

    /**
     * <h1>Cloning linked lists</h1>
     * <br/>
     * We can add support for cloning instances of the {@link SinglyLinkedList} class.
     * The first step to making a class cloneable in Java is declaring that
     * it implements the {@link Cloneable} interface.
     * The remaining task is implementing a public version of the clone() method of
     * the class. By convention, that method should begin  by creating a new instance using a call to
     * super.clone(), which in out case invokes a method from the Object class. Because the inherited
     * version returns an object, we perform a narrowing cast to type SinglyLinkedList&lt;E>.
     * <br/>
     * <br/>
     * At this point in the execution, the other list has been created as a shallow copy of
     * the original. Since our list class has two fields, size and head.
     * For a nonempty list, to have an independent state, it must have an entirely new chain of nodes,
     * each storing a reference to the corresponding element from the original list.
     * We perform then a walk over the remainder of the original list.
     */
    @Test
    @DisplayName("Cloning Linked Lists")
    public void cloningLinkedLists(){
        SinglyLinkedList<Integer> first = new SinglyLinkedList<>();
        first.addFirst(1);
        first.addFirst(2);
        first.addFirst(3);
        SinglyLinkedList<Integer> second = first.clone();
        Assertions.assertTrue(LinkedListUtils.equals(first, second));

    }

    private static class Person implements Cloneable {
        private String name;
        private String surname;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getSurname() {
            return surname;
        }

        public void setSurname(String surname) {
            this.surname = surname;
        }

        @Override
        public Person clone() {
            try {
                Person clone = (Person) super.clone();
                clone.setName(this.name);
                clone.setSurname(this.surname);
                return clone;
            } catch (CloneNotSupportedException e) {
                throw new AssertionError();
            }
        }
    }
}
