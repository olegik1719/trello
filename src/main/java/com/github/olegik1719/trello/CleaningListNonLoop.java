package com.github.olegik1719.trello;

import java.util.*;
import java.util.stream.Collectors;

public class CleaningListNonLoop <T>{

    public static <T> List<T> removeDuplicates(List<T> source){

        return new HashSet<>(source).stream()
                .sorted(Comparator.comparingInt(source::indexOf))
                .collect(Collectors.toList());
    }
}
