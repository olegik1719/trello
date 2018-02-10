package com.github.olegik1719.trello.acmp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ComputerGameTest {

    @Test
    public void minimalEnergy() {
        int[] platforms = {1,5,10};
        assertEquals(9,ComputerGame.minimalEnergy(platforms));
        platforms = new int[]{1, 5, 2};
        assertEquals(3,ComputerGame.minimalEnergy(platforms));
    }
}