package com.github.olegik1719.trello;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeListTest {

    private FreeList<Integer> freeList;
    private final static int initialSize = 1_000;

    @Before
    public void setUp() {
        freeList = new FreeList<>(initialSize);
    }

    @Test
    public void get() {
        assertEquals(initialSize,freeList.size());
        assertNull(freeList.get(999_999));
        assertEquals(initialSize,freeList.size());
    }

    @Test
    public void set() {
        int added = 1_000;
        int position = 999_999;
        freeList.set(position, added);
        assertEquals(added, freeList.get(position).intValue());
        assertEquals(position + 1,freeList.size());
    }

    @Test
    public void remove() {
        int currentsize = freeList.size();
        int bigIndex = 999_999;
        assertNull(freeList.remove(bigIndex));
        assertEquals(currentsize,freeList.size());
    }

    @Test
    public void add() {
        int added = 1000;
        int index = 999_999;
        freeList.add(index, added);
        assertEquals(index+1,freeList.size());
        assertEquals(added, freeList.get(index).intValue());
    }

}