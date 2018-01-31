package com.github.olegik1719.trello;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DFSTest {

    private String[] cities = {"Moscow", "Tula", "Tver", "Ryazan", "Anadyr", "Irkutsk", "Omsk", "Spb", "Tosno", "Novgorod", "Kolpino"};

    private String[][] tableAccessible = {
            {cities[0], cities[1], cities[2], cities[3]},
            {cities[1], cities[4], cities[5], cities[6]},
            {cities[7], cities[5]}
    };
    private String[][] tableUnaccessible = {
            {cities[0], cities[1], cities[2], cities[3]},
            {cities[1], cities[4], cities[5], cities[6]},
            {cities[7], cities[8]},
            {cities[8], cities[9]},
            {cities[10], cities[9]}
    };

    private DFS accessible = new DFS();
    private DFS unaccessible = new DFS();

    @Before
    public void setUp() throws Exception {
        addEdges(accessible, 0, 1, 2, 3);
        addEdges(accessible, 1, 4, 5, 6);
        addEdges(accessible, 7, 5);
        addEdges(unaccessible, 0, 1, 2, 3);
        addEdges(unaccessible, 1, 4, 5, 6);
        addEdges(unaccessible, 7, 8);
        addEdges(unaccessible, 8, 9);
        addEdges(unaccessible, 10, 9);
    }

    @Test
    public void isAccessible() {
        assertTrue(accessible.isAccessible(cities[0],cities[7]));
        assertFalse(unaccessible.isAccessible(cities[0],cities[7]));
    }

    private void addEdges(DFS dfs, int[] data){
    for (int i=1; i<data.size; i++)
        dfs.addEdge(cities[data[0]], cities[data[i]])
    }
}