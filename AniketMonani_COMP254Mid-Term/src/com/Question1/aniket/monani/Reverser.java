package com.Question1.aniket.monani;
/*
Developed by - Aniket Monani
 */
public class Reverser {

    // Recursive method to reverse a string
    public static String reverse(String s) {
        if (s.isEmpty()) {
            return s;
        }
        //s.substring will reverse the string and charAt will retrieve
        //the first character adding both is concatenating characters and returning string
        return reverse(s.substring(1)) + s.charAt(0);
    }
/*
* Student Name - Aniket Monani
* Student Id -   301422485
*/
    public static void main(String[] args) {
        // Test cases
        String test1 = "Aniket";


        // Output of the Reverser
        System.out.println("Original: " + test1 + "  After Reversed: " + reverse(test1));
    }
}
