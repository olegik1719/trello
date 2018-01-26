package com.github.olegik1719.trello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public static <T> List<T> removeDuplicates(List<T> dataArray){
        ArrayList<T> result = new ArrayList<>();
        HashSet<T> alones = new HashSet<>();
        for (T t:dataArray)
            if (alones.add(t))
                result.add(t);
        return result;
    }

    public static <T> List<T> removeDuplicatesNonLoop(List<T> source){
        return source.stream().distinct().collect(Collectors.toList());
    }
}
