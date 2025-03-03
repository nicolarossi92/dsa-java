package it.mauluk92.dsa.c1.s2.utils;

/**
 * We provide a complete implementation of a SinglyLinkedList
 * @param <E> Type of element inside linked list
 */
public class SinglyLinkedList<E> {

    public static class Node<E> {
        private final E element;                    // reference to the element stored at this node
        private Node<E> next;                       // reference to the subsequent node in the list
        public Node(E e, Node<E> n){
            element = e;
            next = n;
        }
        public E getElement(){
            return element;
        }
        public Node<E> getNext(){
            return next;
        }
        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // instance variables of the SinglyLinkedList

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    public SinglyLinkedList(){

    }

    public Node<E> getHeadNode(){
        return head;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if(isEmpty()){
            return null;
        }
        return head.getElement();
    }

    public E last(){
        if(isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){                                // adds element to the front of the list
        head = new Node<>(e, head);                           // create and link a new node
        if (size == 0){
            tail = head;                                      // special case: new node becomes tail also
        }
        size++;
    }

    public void addLast(E e){                                  // adds element e to the end of the list
        Node<E> newest = new Node<>(e, null);               // node will eventually be the tail
        if(isEmpty()){
            head = newest;                                     // special case empty list
        }else {
            tail.setNext(newest);                              // new node after existing tail
        }
        tail = newest;                                         // new node becomes the tail
        size++;
    }

    public E removeFirst(){                                     // removes and returns the first element
        if(isEmpty()){
            return null;                                        // nothing to return in empty list
        }
        E answer = head.getElement();
        head = head.getNext();                                  // will become null if list had only one node
        size--;
        if(size == 0){
            tail = null;                                        // special case when list is empty
        }
        return answer;
    }


}
