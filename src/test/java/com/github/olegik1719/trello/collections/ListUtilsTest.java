package com.github.olegik1719.trello.collections;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListUtilsTest {

    List<Integer> arrayList;
    List<Integer> expected;

    @Before
    public void setUp() throws Exception {
        int max = 100;
        arrayList = new ArrayList<>(max);
        expected = new ArrayList<>(max);
        for (int i = 0; i < max; i++) {
            int r = (int)(java.lang.Math.random()*100);
            if (i>0&&(!expected.contains(r))) expected.add(r);
            for (int j = 0; j < i; j++) arrayList.add(r);
        }

        System.out.printf("Before:%n%s%n", arrayList);

        System.out.printf("Expected after:%n%s%n", expected);
    }

    @Test
    public void removeDuplicates() {
        List<Integer> actual = ListUtils.removeDuplicates(arrayList);
        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicatesNonLoop() {
        List<Integer> actual = ListUtils.removeDuplicatesNonLoop(arrayList);
        assertEquals(expected, actual);
    }

    @Test
    public void removeDuplicatesLinkedHashSet() {
        List<Integer> actual = ListUtils.removeDuplicatesLinkedHashSet(arrayList);
        assertEquals(expected, actual);
    }
}