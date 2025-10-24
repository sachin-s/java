package org.sachin.stringManipulation.lib;

public class StringReverser {

    /**
     * Reverses a given string.
     * Returns empty string if input is null.
     */
    public String reverse(String input) {
        if (input == null) return "";
        return new StringBuilder(input).reverse().toString();
    }
}
