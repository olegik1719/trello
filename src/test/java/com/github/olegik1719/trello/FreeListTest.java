package com.github.olegik1719.trello;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeListTest {

    private FreeList<Integer> freeList;

    @Before
    public void setUp() {
        freeList = new FreeList<>(1_000);
    }

    @Test
    public void get() {
        assertEquals(1_000,freeList.size());
        assertNull(freeList.get(999_999));
        assertEquals(1_000,freeList.size());
    }

    @Test
    public void set() {
        int added = 1_000;
        int position = 999_999;
        assertNull(freeList.set(position, added));
        assertEquals(added, freeList.get(position).intValue());
        assertEquals(position + 1,freeList.size());
    }

    @Test
    public void remove() {
        int currentsize = freeList.size();
        assertNull(freeList.remove(999_999));
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