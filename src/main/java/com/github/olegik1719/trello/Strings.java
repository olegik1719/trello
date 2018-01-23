package com.github.olegik1719.trello;

public class Strings {
    
    public static int countDigits(String string){
        int result = 0;
        for (int i = 0; i < string.length(); i++)
            if(Character.isDigit(string.charAt(i))) result ++;
        return result;
    }
}
