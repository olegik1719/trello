package com.github.olegik1719.trello;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeListTest {

    FreeList<Integer> freeList;

    @Before
    public void setUp() throws Exception {
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
        assertEquals(1_000,freeList.size());
        assertNull(freeList.set(position, added));
        assertEquals(added, freeList.get(position).intValue());
        assertEquals(1_000_000,freeList.size());
    }

    @Test
    public void remove() {
        assertEquals(1_000,freeList.size());
        assertNull(freeList.remove(999_999));
        assertEquals(1_000,freeList.size());
    }

    @Test
    public void add() {
        int added = 1000;
        assertEquals(1_000,freeList.size());
        freeList.add(999_999, added);
        assertEquals(freeList.size(),1_000_000);
        assertEquals(added, freeList.get(999_999).intValue());
    }

}