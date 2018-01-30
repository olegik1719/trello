package com.github.olegik1719.trello.graph.hdh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UndirectedCheckerTest {

    private UndirectedChecker undirectedCheckerAccessible;
    private String[][] tableAccesible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Irkutsk"}
    };
    private UndirectedChecker undirectedCheckerUnaccessible;
    private String[][] tableUnaccesible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Tosno"},
            {"Tosno", "Novgorod"},
            {"Kolpino", "Novgorod"}
    };


    @Before
    public void setUp() throws Exception {

        undirectedCheckerAccessible = new UndirectedChecker(tableAccesible);
        undirectedCheckerUnaccessible = new UndirectedChecker(tableUnaccesible);
    }

    @After
    public void tearDown() throws Exception {
        System.out.printf("Accessible:%n%s%n", undirectedCheckerAccessible);
        System.out.printf("Unaccessible:%n%s%n", undirectedCheckerUnaccessible);
    }

    @Test
    public void isAccessible() {
        assertTrue(undirectedCheckerAccessible.isAccessible("Moscow", "Spb"));
        assertFalse(undirectedCheckerUnaccessible.isAccessible("Moscow", "Spb"));
    }
}