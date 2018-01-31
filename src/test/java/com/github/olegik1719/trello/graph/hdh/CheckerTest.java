package com.github.olegik1719.trello.graph.hdh;

import com.github.olegik1719.trello.graph.DefaultGraph;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckerTest {
    private UndirectedGraph undirectedGraphAccessible;
    
    private String[] cities = {"Moscow", "Tula", "Tver", "Ryazan", "Anadyr", "Irkutsk", "Omsk", "Spb", "Tosno", "Novgorod", "Kolpino"};
    
    private String[][] tableAccesible = {
            {cities[0], cities[1], cities[2], cities[3]},
            {cities[1], cities[4], cities[5], cities[6]},
            {cities[7], cities[5]}
    };
    private UndirectedGraph undirectedGraphUnaccessible;
    private String[][] tableUnaccesible = {
            {cities[0], cities[1], cities[2], cities[3]},
            {cities[1], cities[4], cities[5], cities[6]},
            {cities[7], cities[8]},
            {cities[8], cities[9]},
            {cities[10], cities[9]}
    };

    private DefaultGraph<String> copyAcces;
    private DefaultGraph<String> copyUnacces;

    @Before
    public void setUp() throws Exception {
        copyAcces = new DefaultGraph<>(new UndirectedGraph(tableAccesible));
        copyUnacces = new DefaultGraph<>(new UndirectedGraph(tableUnaccesible));

    }

    @After
    public void tearDown() throws Exception {
        System.out.printf("Accessible:%n%s%n", copyAcces);
        System.out.printf("Unaccessible:%n%s%n", copyUnacces);
    }



    @Test
    public void isAccessibleInUndirect() {
        assertTrue(Checker.isAccessibleInUndirect(copyAcces,"Moscow", "Spb"));
        assertFalse(Checker.isAccessibleInUndirect(copyUnacces,"Moscow", "Spb"));
    }
}