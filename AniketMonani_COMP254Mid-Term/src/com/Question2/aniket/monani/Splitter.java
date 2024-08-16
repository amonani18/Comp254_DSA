package com.Question2.aniket.monani;
/*
Developed by - Aniket Monani
 */
public class Splitter {
    private Node tail;
    private int size;

    // Node class to define the structure of each node
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }
//Hold Null values
    public Splitter() {
        tail = null;
        size = 0;
    }
    // Method to add an element to the circularly linked list
    public void add(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    // Method to split the circularly linked list into two half
    public Splitter[] split() {
        Splitter[] half = new Splitter[2];
        half[0] = new Splitter();
        half[1] = new Splitter();

        if (size <= 1) {
            half[0] = this;
            return half;
        }

        Node slow = tail.next;
        Node fast = tail.next;

        // Use two-pointer technique to find the midpoint
        while (fast.next != tail.next && fast.next.next != tail.next) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Second half starts from the next node after slow
        Node secondHalfStart = slow.next;

        // First half starts from tail.next and ends at slow
        half[0].tail = slow;
        half[0].tail.next = tail.next;
        Node current = tail.next;
        for (int i = 0; i < (size + 1) / 2 - 1; i++) {
            current = current.next;
        }
        half[0].tail = current;
        half[0].tail.next = tail.next;
        half[0].size = (size + 1) / 2;

        // Second half ends at the original tail
        half[1].tail = tail;
        half[1].tail.next = secondHalfStart;
        half[1].size = size / 2;

        // Break the circularity of the first half

        return half;
    }

    // Method to print the circularly linked list
    public void printList() {
        if (tail == null) return;
        Node current = tail.next;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != tail.next);
        System.out.println();
    }
    /*
     * Student Name - Aniket Monani
     * Student Id -   301422485
     */
    public static void main(String[] args) {
        Splitter list = new Splitter();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Original list:");
        list.printList();

        Splitter[] half = list.split();

        System.out.println("First half:");
        half[0].printList();

        System.out.println("Second half:");
        half[1].printList();
    }
}
