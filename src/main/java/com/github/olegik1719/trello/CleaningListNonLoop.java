package com.github.olegik1719.trello;

import java.util.*;
import java.util.stream.Collectors;

public class CleaningListNonLoop {

    public static <T> List<T> removeDuplicates(List<T> source){

        return source.stream().distinct().collect(Collectors.toList());

    }
}
