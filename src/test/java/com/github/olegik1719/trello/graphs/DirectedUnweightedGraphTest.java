package com.github.olegik1719.trello.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DirectedUnweightedGraphTest {

    private static final String[] cities = {"Moscow", "Tula", "Tver", "Ryazan", "Anadyr", "Irkutsk", "Omsk", "Spb", "Tosno", "Novgorod", "Kolpino"};

    private UndirectedUnweightGraph<String> accessible = new UndirectedUnweightGraph<>();
    private UndirectedUnweightGraph<String> unaccessible = new UndirectedUnweightGraph<>();

    @Before
    public void setUp(){
        accessible
                .addNeighbours(cities[0], cities[1], cities[2], cities[3])
                .addNeighbours(cities[1], cities[4], cities[5], cities[6])
                .addNeighbours(cities[7], cities[5])
        ;
        unaccessible
                .addNeighbours(cities[0], cities[1], cities[2], cities[3])
                .addNeighbours(cities[1], cities[4], cities[5], cities[6])
                .addNeighbours(cities[7], cities[8])
                .addNeighbours(cities[8], cities[9])
                .addNeighbours(cities[10], cities[9])
        ;
    }

    @Test
    public void DirectedUnweightedGraph(){
        DirectedUnweightedGraph<String> copyAccess = new DirectedUnweightedGraph<>(accessible);
        DirectedUnweightedGraph<String> copyUnaccess = new DirectedUnweightedGraph<>(unaccessible);
        System.out.printf("Original access:%n%s%nCopy access:%n%s%n",accessible,copyAccess);
        System.out.printf("Original unaccess:%n%s%nCopy unaccess:%n%s%n",unaccessible,copyUnaccess);
    }

}