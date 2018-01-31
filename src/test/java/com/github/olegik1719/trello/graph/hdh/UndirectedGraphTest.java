package com.github.olegik1719.trello.graph.hdh;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UndirectedGraphTest {

    private UndirectedGraph undirectedGraphAccessible;
    private String[][] tableAccessible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Irkutsk"}
    };
    private UndirectedGraph undirectedGraphUnaccessible;
    private String[][] tableUnaccessible = {
            {"Moscow", "Tula", "Tver", "Ryazan"},
            {"Tula", "Anadyr", "Irkutsk", "Omsk"},
            {"Spb", "Tosno"},
            {"Tosno", "Novgorod"},
            {"Kolpino", "Novgorod"}
    };


    @Before
    public void setUp() throws Exception {

        undirectedGraphAccessible = new UndirectedGraph(tableAccessible);
        undirectedGraphUnaccessible = new UndirectedGraph(tableUnaccessible);
    }

    @After
    public void tearDown() throws Exception {
        System.out.printf("Accessible:%n%s%n", undirectedGraphAccessible);
        System.out.printf("Unaccessible:%n%s%n", undirectedGraphUnaccessible);
    }

    @Test
    public void isAccessible() {
        assertTrue(undirectedGraphAccessible.isAccessible("Moscow", "Spb"));
        assertFalse(undirectedGraphUnaccessible.isAccessible("Moscow", "Spb"));
    }
}