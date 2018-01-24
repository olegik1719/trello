package com.github.olegik1719.trello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CleaningListNonLoop <T>{

    private List<T> result;
    private List<T> source;
    private Set<T> objects;

    private CleaningListNonLoop(List<T> source){
            result = new ArrayList<>();
            this.source = source;
            objects = new HashSet<>();
    }

    private List<T> cleanIt(int index){
        if (index == source.size())
            return result;
        T current = source.get(index);
        if (objects.add(current))
            result.add(current);
        return cleanIt(++index);
    }

    public static <T> List<T> removeDuplicates(List<T> source){
        return new CleaningListNonLoop<T>(source).cleanIt(0);
    }
}
