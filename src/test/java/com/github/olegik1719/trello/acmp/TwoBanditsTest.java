package com.github.olegik1719.trello.acmp;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoBanditsTest {

    @Test
    public void nonShooted() {
        int garry = 7;
        int larry = 8;
        int[] nonShooted = TwoBandits.nonShooted(garry,larry);
        assertEquals(larry - 1,nonShooted[0]);
        assertEquals(garry - 1,nonShooted[1]);
    }
}