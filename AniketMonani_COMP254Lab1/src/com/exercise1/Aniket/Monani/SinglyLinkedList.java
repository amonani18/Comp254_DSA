package com.exercise1.Aniket.Monani;

public class SinglyLinkedList<E> {
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() { return element; }
        public Node<E> getNext() { return next; }
        public void setNext(Node<E> n) { next = n; }
    }

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList() { }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }
    public E first() {
        if (isEmpty()) return null;
        return head.getElement();
    }
    public E last() {
        if (isEmpty()) return null;
        return tail.getElement();
    }
    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (size == 0)
            tail = head;
        size++;
    }
    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty())
            head = newest;
        else
            tail.setNext(newest);
        tail = newest;
        size++;
    }
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
    //    Aniket Monani
    //    301422485
    public static void main(String[] args) {
        SinglyLinkedList<String> list = new SinglyLinkedList<>();
        list.addFirst("MSP");
        list.addLast("ATL");
        list.addLast("BOS");
        list.addFirst("LAX");

        System.out.println("Original list: " + list);

        Node<String> node1 = list.head.getNext(); // MSP
        Node<String> node2 = list.head.getNext().getNext().getNext(); // BOS

        list.swapTwoNodes(node1, node2);

        System.out.println("List after swapping nodes: " + list);
    }
}
