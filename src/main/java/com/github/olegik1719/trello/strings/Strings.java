package com.github.olegik1719.trello.strings;

import java.util.ArrayList;
import java.util.List;

public class Strings {
    
    public static int countDigits(String string){
        int result = 0;
        for (int i = 0; i < string.length(); i++)
            if(Character.isDigit(string.charAt(i))) result ++;
        return result;
    }

    public static List<Integer> substring(String string, String substing){
        List<Integer> result = new ArrayList<>(string.length());
        int fromIndex = 0;
        while ((fromIndex = string.indexOf(substing,fromIndex)) != -1){
            result.add(fromIndex++);
        }
        return result;
    }
}
