package com.github.olegik1719.trello;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FreeListTest {

    @Test
    public void get() {
        FreeList<Integer> freeList = new FreeList<>(1_000);
        assertEquals(freeList.size(),1_000);
        assertNull(freeList.get(999_999));
        assertEquals(freeList.size(),1_000_000);

        //freeList = new FreeList<>(1_000);
    }
}