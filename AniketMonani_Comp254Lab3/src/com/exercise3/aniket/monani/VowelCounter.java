package com.exercise3.aniket.monani;

import java.util.Scanner;

/**
 * This class provides functionality to count vowels and consonants in a string
 * and determine if the string has more vowels than consonants.
 * Student Name - Aniket Monani
 * Student ID   - 301422485
 */
public class VowelCounter {

    /**
     * Recursively counts the number of vowels and consonants in a given string.
     *
     * @param s the string to be processed
     * @param index the current index in the string
     * @param counts an array where counts[0] is the number of vowels and counts[1] is the number of consonants
     */
    private static void countVowelsAndConsonants(String s, int index, int[] counts) {
        // Base case: if the index reaches the end of the string
        if (index == s.length()) {
            return;
        }

        // Check the current character
        char currentChar = s.charAt(index);

        // Determine if it is a vowel or consonant
        if (Character.isLetter(currentChar)) {
            char lowerChar = Character.toLowerCase(currentChar);
            if (lowerChar == 'a' || lowerChar == 'e' || lowerChar == 'i' || lowerChar == 'o' || lowerChar == 'u') {
                counts[0]++; // Increment vowel count
            } else {
                counts[1]++; // Increment consonant count
            }
        }
        // Recur for the next character
        countVowelsAndConsonants(s, index + 1, counts);
    }

    /**
     * Wrapper method to determine if the string has more vowels than consonants.
     *
     * @param s the string to be checked
     * @return true if the string has more vowels than consonants, false otherwise
     */
    public static boolean hasMoreVowels(String s) {
        int[] counts = new int[2]; // counts[0] for vowels, counts[1] for consonants
        countVowelsAndConsonants(s, 0, counts);
        return counts[0] > counts[1];
    }

    /**
     * Main method to execute the vowel and consonant counting functionality.
     *
     *  
     * Prompts the user to enter a string and then prints whether the string has
     * more vowels than consonants.
     *  
     *
     * @param args command line arguments (not used)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to check if it has more vowels than consonants: ");
        String input = scanner.nextLine();

        // Determine if the string has more vowels than consonants
        boolean result = hasMoreVowels(input);

        // Print the result
        if (result) {
            System.out.println("The string \"" + input + "\" has more vowels than consonants.");
        } else {
            System.out.println("The string \"" + input + "\" has more consonants than vowels or an equal number of both.");
        }

        scanner.close(); // Close the scanner to avoid resource leak
    }
}
