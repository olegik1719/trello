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

    private DFS accessible;
    private DFS unaccessible;

    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void recoursiveAlgo() {
    }
}