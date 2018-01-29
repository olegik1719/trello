package com.github.olegik1719.trello.graph;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerGraphTest {

    @Test
    public void addVertex(){
        IntegerGraph integerGraph = new IntegerGraph();
        integerGraph.addVertex(23);
        integerGraph.addVertex(56);
        integerGraph.addEdge(new DefaultEdge<>(23,56,false));
        System.out.printf("%s: %s%n", integerGraph.getVerticesCount(),integerGraph.getVertices());
        System.out.printf("%s: %s%n", integerGraph.getEdgesCount(),integerGraph.getEdges());
    }
}