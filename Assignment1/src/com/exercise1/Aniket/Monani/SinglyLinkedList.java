package com.exercise1.Aniket.Monani;

/**
 * An implementation of a singly linked list.
 *
 * This class provides functionality to create and manipulate a singly linked list data structure.
 * It supports operations such as adding elements to the front or back of the list, accessing the first
 * and last elements, swapping two nodes, and generating a string representation of the list.
 *
 * @param <E> the type of elements stored in the list
 *
 * @author Aniket Monani
 * @version 301422485
 */
public class SinglyLinkedList<E> {

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
     * Constructs an empty singly linked list.
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
     * Swaps two nodes in the list given their references.
     *
     * @param node1 reference to the first node to be swapped
     * @param node2 reference to the second node to be swapped
     */
    public void swapTwoNodes(Node<E> node1, Node<E> node2) {
        if (node1 == node2) {
            return;
        }

        Node<E> prev1 = null, prev2 = null, curr = head;

        // Find previous nodes of node1 and node2
        while (curr != null) {
            if (curr.getNext() == node1) prev1 = curr;
            if (curr.getNext() == node2) prev2 = curr;
            curr = curr.getNext();
        }

        // If either node1 or node2 is not present, do nothing
        if (node1 == null || node2 == null) return;

        // If node1 or node2 is head, update head
        if (head == node1) head = node2;
        else if (head == node2) head = node1;

        // If node1 or node2 is tail, update tail
        if (tail == node1) tail = node2;
        else if (tail == node2) tail = node1;

        // Swap the nodes by adjusting the next pointers
        if (prev1 != null) prev1.setNext(node2);
        if (prev2 != null) prev2.setNext(node1);

        Node<E> temp = node1.getNext();
        node1.setNext(node2.getNext());
        node2.setNext(temp);
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
        // Create a singly linked list and perform operations
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("MSP");
        list.addLast("ATL");
        list.addLast("BOS");
        list.addLast("LAX");

        System.out.println("Original list: " + list);

        Node<String> node1 = list.head; // Reference to ATL
        Node<String> node2 = list.head.getNext(); // Reference to BOS

        list.swapTwoNodes(node1, node2);

        System.out.println("List after swapping nodes: " + list);
    }
}
