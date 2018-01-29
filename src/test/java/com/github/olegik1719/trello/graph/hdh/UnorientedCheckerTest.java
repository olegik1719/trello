package com.github.olegik1719.trello.graph.hdh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class UnorientedCheckerTest {

    private UnorientedChecker unorientedCheckerAccessible;
    private String[][] tableAccesible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Irkutsk"}
    };
    private UnorientedChecker unorientedCheckerUnAccessible;
    private String[][] tableUnAccesible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Tosno"},
            {"Tosno", "Novgorod"},
            {"Kolpino", "Novgorod"}
    };


    @Before
    public void setUp() throws Exception {

        unorientedCheckerAccessible = new UnorientedChecker(tableAccesible);
        unorientedCheckerUnAccessible = new UnorientedChecker(tableUnAccesible);
    }

    @After
    public void tearDown() throws Exception {
        System.out.printf("Accessible:%n%s%n", unorientedCheckerAccessible);
        System.out.printf("Unaccessible:%n%s%n",unorientedCheckerUnAccessible);
    }

    @Test
    public void isAccessible() {
        assertTrue(unorientedCheckerAccessible.isAccessible("Moscow", "Spb"));
        assertFalse(unorientedCheckerUnAccessible.isAccessible("Moscow", "Spb"));
    }
}