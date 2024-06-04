package com.exercise2.Aniket.Monani;

/**
 * A basic implementation of a singly linked list.
 *
 * This class provides functionality to create and manipulate a singly linked list data structure.
 * It supports operations such as adding elements to the front or back of the list, accessing the first
 * and last elements, concatenating two lists, and generating a string representation of the list.
 *
 * @param <E> the type of elements stored in the list
 *
 * @author Aniket Monani
 * @version 301422485
 */
public class SinglyLinkedList<E>  {

    // Nested Node class for representing elements in the list
    private static class Node<E> {
        private E element;          // the element stored at this node
        private Node<E> next;       // reference to the subsequent node

        /**
         * Constructs a node with the given element and next node.
         *
         * @param e the element to be stored in the node
         * @param n the reference to the next node
         */
        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        // Accessor methods
        public E getElement() { return element; }
        public Node<E> getNext() { return next; }

        // Modifier method
        public void setNext(Node<E> n) { next = n; }
    }

    // Instance variables
    private Node<E> head = null;    // reference to the first node of the list
    private Node<E> tail = null;    // reference to the last node of the list
    private int size = 0;           // number of elements in the list

    /**
     * Constructs an initially empty singly linked list.
     */
    public SinglyLinkedList() { }

    // Access methods

    /**
     * Returns the number of elements in the linked list.
     *
     * @return the number of elements in the list
     */
    public int size() { return size; }

    /**
     * Checks if the linked list is empty.
     *
     * @return true if the list is empty, false otherwise
     */
    public boolean isEmpty() { return size == 0; }

    /**
     * Returns the first element of the list without removing it.
     *
     * @return the first element of the list, or null if the list is empty
     */
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    /**
     * Returns the last element of the list without removing it.
     *
     * @return the last element of the list, or null if the list is empty
     */
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    // Update methods

    /**
     * Adds an element to the front of the list.
     *
     * @param e the element to be added
     */
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }

    /**
     * Adds an element to the end of the list.
     *
     * @param e the element to be added
     */
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }

    /**
     * Concatenates another singly linked list to this list.
     *
     * @param other the list to be concatenated
     */
    public void concatenate(SinglyLinkedList<E> other) {
        if (this.isEmpty()) {          // if the first list is empty
            this.head = other.head;
            this.tail = other.tail;
        } else if (!other.isEmpty()) { // if both lists are non-empty
            this.tail.setNext(other.head);
            this.tail = other.tail;
        }
        this.size += other.size;
    }

    /**
     * Returns a string representation of the list.
     *
     * @return a string representation of the list
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk != tail)
                sb.append(", ");
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }

//      Main method for testing
//     * @ Aniket Monani
//      * @ 301422485
    public static void main(String[] args) {
        // First list
        SinglyLinkedList<String> list1 = new SinglyLinkedList<>();
        list1.addFirst("MSP");
        list1.addLast("ATL");
        list1.addLast("BOS");
        list1.addLast("LAX");
        System.out.println("List 1: " + list1);

        // Second list
        SinglyLinkedList<String> list2 = new SinglyLinkedList<>();
        list2.addFirst("JFK");
        list2.addLast("ORD");
        System.out.println("List 2: " + list2);

        // Concatenate lists
        list1.concatenate(list2);
        System.out.println("Concatenated List: " + list1);
    }

}
