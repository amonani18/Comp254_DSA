package com.exercise2.aniket.monani;

import java.util.Scanner;

/**
 * This class provides functionality to check if a given string is a palindrome.
 * Student Name - Aniket Monani
 * Student ID   - 301422485
 */
public class PalindromeChecker {

    /**
     * Recursive method to check if a string is a palindrome.
     * @param s the string to be checked
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindrome(String s) {
        // Base case: a string with length 0 or 1 is a palindrome
        if (s.length() <= 1) {
            return true;
        }

        // Recursive case: check if the first and last characters are the same
        // and the substring excluding those characters is a palindrome
        if (s.charAt(0) == s.charAt(s.length() - 1)) {
            // Check the substring without the first and last characters
            return isPalindrome(s.substring(1, s.length() - 1));
        }

        // If the first and last characters are not the same, it's not a palindrome
        return false;
    }

    /**
     * Main method to execute the palindrome checking functionality.
     *
     *   
     * Prompts the user to enter a string and then prints whether the string is
     * a palindrome.
     *  
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it is a palindrome: ");
        String input = scanner.nextLine();

        // Check if the input string is a palindrome
        boolean result = isPalindrome(input);

        // Print the result
        if (result) {
            System.out.println("The string \"" + input + "\" is a palindrome.");
        } else {
            System.out.println("The string \"" + input + "\" is not a palindrome.");
        }

        scanner.close(); // Close the scanner to avoid resource leak
    }
}
