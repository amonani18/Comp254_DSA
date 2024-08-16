package com.exercise1.aniket.monani;

/**
 * This class provides a recursive method to compute the product of two positive integers.
 * Student Name - Aniket Monani
 * Student ID   - 301422485
 */
public class Recursive {

    /**
     * Recursive method to compute the product of two positive integers.
     *
     * @param m the first positive integer
     * @param n the second positive integer
     * @return the product of m and n
     */
    public static int recursiveProduct(int m, int n) {
        // If either number is 0, the product is 0
        if (m == 0 || n == 0) {
            return 0;
        }
        // Recursive case: add m to the product of m and (n-1)
        return m + recursiveProduct(m, n - 1);
    }

    /**
     * Main method to test the recursiveProduct method.
     *
     *   
     * Sets example values for m and n, computes their product using the recursiveProduct method,
     * and prints the result.
     *   
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        int m = 5; // First positive integer
        int n = 4; // Second positive integer
        int result = recursiveProduct(m, n); // Compute the product
        System.out.println("The product of " + m + " and " + n + " is " + result); // Print the result
    }
}
