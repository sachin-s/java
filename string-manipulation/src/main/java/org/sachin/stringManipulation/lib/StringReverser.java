package org.sachin.stringManipulation.lib;

public class StringReverser {

    /**
     * Reverses a given string.
     * Returns empty string if input is null.
     */
    public String StringBufferReverse(String input) {
        if (input == null) return "";
        return new StringBuffer(input).reverse().toString();
    }

    /*
    String reversing using Stream object
     */
    public String StreamStringReverse(String input){
        if (input== null) return "";
        return input.chars()
                .mapToObj(c -> (char) c)
                .map(String::valueOf)
                .reduce("", (a, b) -> b + a);
    }
    /*
    String reversing using loop
     */
    public String LoopStringReverse(String input){
        StringBuffer s = new StringBuffer();
        if (input == null) return "";
        for (int i = input.length() - 1; i >=0 ; i--)
        {
            s.append(input.charAt(i));
        }
        return s.toString();
    }

    /*
    String reversing using recursion
     */
    public String RecurssionStringReverse(String input){

        if ( input == null ) return "";
        if ( input.length() <= 1 ) return input;

        return RecurssionStringReverse(input.substring(1))+input.charAt(0);
    }
}