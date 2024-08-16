package com.exercise1.aniket.monani;

/*
 * Copyright 2014, Michael T. Goodrich, Roberto Tamassia, Michael H. Goldwasser
 *
 *
 *
 *	Developed by Aniket Monani
 *
 *	Student ID: 301422485
*/ 


class Exercises1 {

    // running time is O(n)
    /** 
     * Returns the sum of the integers in given array.
     *
     * @param arr the array of integers
     * @return the sum of the integers in the array
     *
     * The time complexity is O(n) because the method iterates through 
     * the entire array once, performing a constant time addition operation
     * for each element.
     */
    public static int example1(int[] arr) {
        int n = arr.length, total = 0;  // O(1)
        for (int j = 0; j < n; j++) {   // O(n)
            total += arr[j];            // O(1)
        }
        return total;
    }
    // Big-O = O(n)

    /**
     * Returns the sum of the integers with even index in given array.
     *
     * @param arr the array of integers
     * @return the sum of the integers with even indices
     *
     * The time complexity is O(n) because the method iterates through 
     * half of the array (every second element), but in Big-O notation, 
     * constant factors are ignored, so it is still O(n).
     */
    public static int example2(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j += 2) {  // loop runs n/2 times
            total += arr[j];
        }
        return total;
    }
    // Big-O = O(n) 

    /**
     * Returns the sum of the prefix sums of given array.
     *
     * @param arr the array of integers
     * @return the sum of the prefix sums
     *
     * The time complexity is O(n^2) because there is a nested loop structure:
     * - The outer loop runs n times.
     * - The inner loop runs j+1 times, where j ranges from 0 to n-1.
     * This results in a total of (n*(n+1))/2 iterations, which simplifies to O(n^2).
     */
    public static int example3(int[] arr) {
        int n = arr.length, total = 0;
        for (int j = 0; j < n; j++) {     // O(n)
            for (int k = 0; k <= j; k++) { // O(n^2)
                total += arr[j];
            }
        }
        return total;
    }
    // Big-O = O(n^2)

    /**
     * Returns the sum of the prefix sums of given array.
     *
     * @param arr the array of integers
     * @return the sum of the prefix sums
     *
     * The time complexity is O(n) because the method iterates through 
     * the array once, updating the prefix sum and total sum in constant time.
     */
    public static int example4(int[] arr) {
        int n = arr.length, prefix = 0, total = 0;
        for (int j = 0; j < n; j++) {     // O(n)
            prefix += arr[j];             // O(1) - updating value
            total += prefix;              // O(1) - updating value
        }
        return total;
    }
    // Big-O = O(n)

    /**
     * Returns the number of times second array stores sum of prefix sums from first.
     *
     * @param first the first array of integers
     * @param second the second array of integers
     * @return the count of matches where second[i] equals the sum of prefix sums of first
     *
     * The time complexity is O(n^3) because:
     * - The outer loop runs n times.
     * - The middle loop runs n times.
     * - The inner loop runs j+1 times, where j ranges from 0 to n-1.
     * This results in a total of n^3 iterations.
     */
    public static int example5(int[] first, int[] second) { // assume equal-length arrays
        int n = first.length, count = 0;
        for (int i = 0; i < n; i++) {     // O(n)
            int total = 0;
            for (int j = 0; j < n; j++) { // O(n)
                for (int k = 0; k <= j; k++) { // O(n^2)
                    total += first[k];
                }
            }
            if (second[i] == total) count++;
        }
        return count;
    }
    // Big-O = O(n^3)
}
