package com.github.olegik1719.trello;

import com.github.olegik1719.trello.collections.ListUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListUtilsTest {

    List<Integer> arrayList;
    List<Integer> cleanedList;

    @Before
    public void setUp() throws Exception {
        int max = 10;
        arrayList = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            int r = (int)(java.lang.Math.random()*100);
            for (int j = 0; j < i; j++) arrayList.add(r);
        }

        for (int i: arrayList) {
            System.out.printf("%s ", i);
        }
        System.out.printf("%n");
    }

    @Test
    public void removeDuplicates() {
        cleanedList = ListUtils.removeDuplicates(arrayList);
    }

    @Test
    public void removeDuplicatesNonLoop() {
        cleanedList = ListUtils.removeDuplicatesNonLoop(arrayList);
    }

    @After
    public void tearDown() throws Exception {
        for (int i: cleanedList) {
            System.out.printf("%s ", i);
        }
        System.out.printf("%n");
    }
}