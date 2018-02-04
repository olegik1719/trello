package com.github.olegik1719.trello.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleDijkstraImplementationTest {

    private ExampleDijkstraImplementation<String> accessible = new ExampleDijkstraImplementation<>();
    private ExampleDijkstraImplementation<String> unaccessible = new ExampleDijkstraImplementation<>();

    private static final String[] cities = {"Moscow", "Tula", "Tver", "Ryazan", "Anadyr", "Irkutsk", "Omsk", "Spb", "Tosno", "Novgorod", "Kolpino"};

    @Before
    public void setUp() {
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
    public void getDijkstra(){
        System.out.printf("%s%n", accessible.getDijkstra(cities[0]));
        System.out.printf("%s%n", unaccessible.getDijkstra(cities[0]));
    }

}