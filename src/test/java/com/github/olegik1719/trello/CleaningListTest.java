package com.github.olegik1719.trello;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class CleaningListTest {

    @Test
    public void removeDoubles() {
        int max = 10;
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < max; i++)
            for (int j = 0; j < i; j++)
                arrayList.add(max - i);

        for (int i: arrayList) {
            System.out.printf("%s ", i);
        }
        System.out.printf("%n");

        ArrayList<Integer> cleanedList = CleaningList.RemoveDoubles(arrayList);
        for (int i: cleanedList) {
            System.out.printf("%s ", i);
        }
        System.out.printf("%n");
    }
}