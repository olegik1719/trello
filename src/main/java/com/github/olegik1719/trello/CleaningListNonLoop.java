package com.github.olegik1719.trello;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CleaningListNonLoop <T>{

    public static <T> List<T> removeDuplicates(List<T> source){
        return new ArrayList(new HashSet(source));
    }
}
