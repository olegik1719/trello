package com.github.olegik1719.trello.strings;

public class Strings {
    
    public static int countDigits(String string){
        int result = 0;
        for (int i = 0; i < string.length(); i++)
            if(Character.isDigit(string.charAt(i))) result ++;
        return result;
    }

    public static boolean isPalindrome(String string){
        for (int i = 0; i < string.length()/2; i++) {
            if (string.charAt(i) != string.charAt(string.length() - 1 - i))
                return false;
        }
        return true;
    }
}
