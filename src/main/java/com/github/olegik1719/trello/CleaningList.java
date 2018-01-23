package com.github.olegik1719.trello;

import java.util.ArrayList;
import java.util.HashSet;

public class CleaningList {
    public static <T> ArrayList<T> RemoveDoubles(ArrayList<T> dataArray){
        ArrayList<T> result = new ArrayList<>();
        HashSet<T> alones = new HashSet<>();
        for (T t:dataArray)
            if (alones.add(t))
                result.add(t);
        return result;
    }
}
