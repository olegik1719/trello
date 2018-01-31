package com.github.olegik1719.trello.graph.hdh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UndirectedGraphTest {

    private UndirectedGraph undirectedGraphAccessible;
    private String[][] tableAccesible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Irkutsk"}
    };
    private UndirectedGraph undirectedGraphUnaccessible;
    private String[][] tableUnaccesible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Tosno"},
            {"Tosno", "Novgorod"},
            {"Kolpino", "Novgorod"}
    };


    @Before
    public void setUp() throws Exception {

        undirectedGraphAccessible = new UndirectedGraph(tableAccesible);
        undirectedGraphUnaccessible = new UndirectedGraph(tableUnaccesible);
    }

    @After
    public void tearDown() throws Exception {
        System.out.printf("Accessible:%n%s%n", undirectedGraphAccessible);
        System.out.printf("Unaccessible:%n%s%n", undirectedGraphUnaccessible);
    }

    @Test
    public void isAccessible() {
        assertTrue(Checker.isAccessibleInUndirect(undirectedGraphAccessible,"Moscow", "Spb"));
        assertFalse(Checker.isAccessibleInUndirect(undirectedGraphUnaccessible,"Moscow", "Spb"));
    }
}