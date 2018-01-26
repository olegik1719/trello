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
        assertEquals(freeList.size(),1_000);
        assertNull(freeList.get(999_999));
        assertEquals(freeList.size(),1_000_000);
    }

    @Test
    public void set() {
        assertEquals(freeList.size(),1_000);
        assertNull(freeList.set(999_999, 1_000));
        assertEquals(freeList.size(),1_000_000);
    }

    @Test
    public void remove() {
        assertEquals(freeList.size(),1_000);
        assertNull(freeList.remove(999_999));
        assertEquals(freeList.size(),999_999);
    }

    @Test
    public void add() {
        assertEquals(freeList.size(),1_000);
        freeList.add(999_999, 1_000);
        assertEquals(freeList.size(),1_000_000);
        assertEquals((Object)freeList.get(999_999),1_000);
    }

}