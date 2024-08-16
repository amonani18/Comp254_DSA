package com.exercise3.aniket.monani;

import java.util.Random;

/**
 * Developed by Aniket Monani
 * Student ID: 301422485
 *
 * This class contains a method to find the missing number in an array containing n-1 unique integers
 * in the range [0, n-1], and a main method to test the implementation.
 */
public class Exercise3 {

    /**
     * Finds the missing number in an array containing n-1 unique integers in the range [0, n-1].
     * The algorithm runs in O(n) time and uses O(1) additional space.
     *
     * @param A the input array containing n-1 unique integers in the range [0, n-1]
     * @return the missing number in the array
     */
    public static int findMissingNumber(int[] A) {
        int n = A.length + 1;  // The array A has n-1 elements, so n is A.length + 1
        int expectedSum = n * (n - 1) / 2;  // Sum of numbers from 0 to n-1
        int actualSum = 0;

        // Calculate the sum of elements in the array
        for (int i = 0; i < A.length; i++) {
            actualSum += A[i];
        }

        // The missing number is the difference between expected sum and actual sum
        return expectedSum - actualSum;
    }

    // Time Complexity: O(n)

    /**
     * Main method to test the implementation of findMissingNumber.
     *
     * @param args command-line arguments (not used)
     */
    
    //Student Name: Aniket Monani
    //Student ID: 301422485
    public static void main(String[] args) {
        // Test the method with an example array
        int n = 10;  // Let's say n is 10 (we'll have numbers from 0 to 9)
        int missingNumber = 5;  // Let's say the missing number is 5
        int[] array = new int[n - 1];

        // Fill the array with numbers from 0 to n-1, excluding the missing number
        int index = 0;
        for (int i = 0; i < n; i++) {
            if (i != missingNumber) {
                array[index++] = i;
            }
        }

        // Shuffle the array (optional, for more realistic testing)
        shuffleArray(array);

        // Print the array
        System.out.print("Array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Find and print the missing number
        int result = findMissingNumber(array);
        System.out.println("Missing number: " + result);
    }

    /**
     * Helper method to shuffle the array for more realistic testing.
     *
     * @param array the array to be shuffled
     */
    private static void shuffleArray(int[] array) {
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--) {
            int index = random.nextInt(i + 1);
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
