package com.github.olegik1719.trello.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UndirectedUnweightedGraphTest {
    private  static UndirectedUnweightedGraph graph;

    private final static int[] data = {1,2,3,4,5,6,7,8,9,10,11};

    @Before
    public void setUp() throws Exception {
        graph = new UndirectedUnweightedGraph();
    }

    @Test
    public void addVertex() {
        graph.addVertex(data[0])
                .addVertex(data[1]);
        assertEquals(2,graph.countVertices());
    }

    @Test
    public void addEdge() {
        graph.addVertex(data[3])
                .addEdge(data[3],data[4]);
        assertTrue(graph.containsEdge(data[3],data[4]));
        assertTrue(graph.containsVertex(data[4]));
    }

    @Test
    public void isVertex() {
        graph.addVertex(data[5])
                .addVertex(data[6]);
        assertTrue(graph.containsVertex(data[5]));
    }

    @Test
    public void isEdge() {
        assertTrue(graph
                .addVertex(data[7])
                .addVertex(data[8])
                .addEdge(data[7],data[8])
                .containsEdge(data[7],data[8]));
    }

    @Test
    public void countVertices() {
        assertEquals(6,graph.
                addEdge(data[0],data[1])
                .addEdge(data[2],data[3])
                .addEdge(data[4],data[5])
                .countVertices()
        );
    }

    @Test
    public void countEdges() {
        assertEquals(3,graph.
                addEdge(data[0],data[1])
                .addEdge(data[2],data[3])
                .addEdge(data[4],data[5])
                .countEdges()
        );
    }

    @Test
    public void vertices() {
        System.out.printf("%s%n", graph.addVertex(data[0])
                        .addVertex(data[1])
                        .addVertex(data[2])
                        .addVertex(data[3])
                        .addVertex(data[4])
                        .addVertex(data[5])
                        .addVertex(data[6])
                        .addVertex(data[7])
                        .vertices()
        );
    }
}