package com.Question3.aniket.monani;
import java.util.Arrays;
/*
Developed by - Aniket Monani
 */
public class Largest_Element {
    // Method to find the ten largest elements in an array
    public static int[] findTenLargest(int[] array) {
        if (array.length <= 10) {
            // If the array has 10 or fewer elements, return the sorted array
            Arrays.sort(array);
            return array;
        }

        // Auxiliary array to store the ten largest elements
        int[] largest = new int[10];
        Arrays.fill(largest, Integer.MIN_VALUE);

        // Iterate over the input array
        for (int num : array) {
            // Check where the current number fits in the largest array
            for (int i = 0; i < 10; i++) {
                if (num > largest[i]) {
                    // Shift elements to the right and insert the new number
                    for (int j = 9; j > i; j--) {
                        largest[j] = largest[j - 1];
                    }
                    largest[i] = num;
                    break;
                }
            }
        }

        return largest;
    }
    /*
     * Student Name - Aniket Monani
     * Student Id -   301422485
     */
    public static void main(String[] args) {
        // Test array
        //Time Complexity is O(n) where n is the size of input in array as we need to compare each element's
        int[] array = {5, 52, 8, 88, 6, 44, 4, 99, 47, 148, 5, 580, 5, 25, 59, 88};

        // Find the ten largest elements
        int[] tenLargest = findTenLargest(array);

        // Print the results
        System.out.println("The ten largest elements are:");
        for (int num : tenLargest) {
            System.out.print(num + " ");
        }
        System.out.println("Time Complexity ");
    }
}