package com.exercise2.aniket.monani;

import java.util.Comparator;

public class BottomUpMergeSort {

    // Method to merge two sorted queues into a single sorted queue
    public static <T> LinkedQueue<T> merge(LinkedQueue<T> q1, LinkedQueue<T> q2, Comparator<T> comp) {
        // Create a new queue to store the merged results
        LinkedQueue<T> result = new LinkedQueue<>();
        
        // Continue merging while both queues have elements
        while (!q1.isEmpty() && !q2.isEmpty()) {
            // Compare the front elements of both queues and enqueue the smaller one
            if (comp.compare(q1.first(), q2.first()) <= 0) {
                result.enqueue(q1.dequeue());
            } else {
                result.enqueue(q2.dequeue());
            }
        }
        
        // Enqueue any remaining elements from q1
        while (!q1.isEmpty()) {
            result.enqueue(q1.dequeue());
        }
        
        // Enqueue any remaining elements from q2
        while (!q2.isEmpty()) {
            result.enqueue(q2.dequeue());
        }
        
        // Return the merged queue
        return result;
    }

    // Method to perform bottom-up merge sort on a queue of items
    public static <T> LinkedQueue<T> bottomUpMergeSort(LinkedQueue<T> items, Comparator<T> comp) {
        // Create a LinkedQueue to manage merging of individual queues
        LinkedQueue<LinkedQueue<T>> queueOfQueues = new LinkedQueue<>();
        // Place each item into its own single-item queue
        while (!items.isEmpty()) {
            LinkedQueue<T> singleItemQueue = new LinkedQueue<>();
            singleItemQueue.enqueue(items.dequeue());
            queueOfQueues.enqueue(singleItemQueue);
        }
        // Merge the queues until only one sorted queue remains
        while (queueOfQueues.size() > 1) {
            LinkedQueue<T> q1 = queueOfQueues.dequeue(); // Dequeue first queue
            LinkedQueue<T> q2 = queueOfQueues.dequeue(); // Dequeue second queue
            LinkedQueue<T> mergedQueue = merge(q1, q2, comp); // Merge the two queues
            queueOfQueues.enqueue(mergedQueue); // Enqueue the merged queue back into the main queue
        }
        // Return the final sorted queue
        return queueOfQueues.dequeue();
    }
    public static void main(String[] args) {
        // Create a LinkedQueue of sample integers to sort
        LinkedQueue<Integer> items = new LinkedQueue<>();
        items.enqueue(6);
        items.enqueue(2);
        items.enqueue(5);
        items.enqueue(3);
        items.enqueue(7);
        items.enqueue(8);
        // Create a Comparator object to define the order of sorting
        Comparator<Integer> comp = new Comparator<Integer>() {
            public int compare(Integer i1, Integer i2) {
                return i1.compareTo(i2); // Compare integers in natural ascending order
            }
        };
        // Perform bottom-up merge sort on the queue of integers
        LinkedQueue<Integer> sortedItems = bottomUpMergeSort(items, comp);
        // Print the sorted items
        System.out.println("Sorted items: " + sortedItems);
    }
}