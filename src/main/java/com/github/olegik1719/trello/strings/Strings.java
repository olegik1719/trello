package com.github.olegik1719.trello.strings;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    /**
     * Count digits in string.
     * Complexity is O(length).
     * @param string to search digits
     * @return count of digits.
     */
    public static int countDigits(String string){
        int result = 0;
        for (int i = 0; i < string.length(); i++)
            if(Character.isDigit(string.charAt(i))) result ++;
        return result;
    }

    /**
     * Detect is the string palindrome or not
     * Complexity is O(length)
     * @param string for detection
     * @return true if the string is palindrome, false otherwise
     */
    public static boolean isPalindrome(String string){
        for (int i = 0; i < string.length()/2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static List<Integer> substring(String string, String substring){
        List<Integer> result = new ArrayList<>(string.length()+1);

        if (substring.length() == 0){
            for (int i = 0; i <= string.length(); i++)
                result.add(i);
            return result;
        }

        for (int i = 0; i<=string.length() - substring.length(); i++){
            int j = 0;
            while (j<substring.length()
                    && i+j<string.length()
                    && string.charAt(i+j)==string.charAt(j)){
                j++;
            }
            if (j == substring.length())
                result.add(i);
        }
        return result;
    }

}
