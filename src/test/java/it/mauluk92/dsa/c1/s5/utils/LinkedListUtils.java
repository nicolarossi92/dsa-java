package it.mauluk92.dsa.c1.s5.utils;

import it.mauluk92.dsa.c1.s2.utils.SinglyLinkedList;

public class LinkedListUtils {

    public static <E> boolean equals(SinglyLinkedList<E> first, SinglyLinkedList<E> second) {
        if (first == null || second == null) {
            return false;
        }
        if (first.size() != second.size()) {
            return false;
        }
        SinglyLinkedList.Node<E> firstWalkNode = first.getHeadNode();
        SinglyLinkedList.Node<E> secondWalkNode = second.getHeadNode();
        while (firstWalkNode != null) {
            if (!firstWalkNode.getElement().equals(secondWalkNode.getElement())) {
                return false;
            }
            firstWalkNode = firstWalkNode.getNext();
            secondWalkNode = secondWalkNode.getNext();
        }
        return true;
    }
}
