package com.github.olegik1719.trello.graph;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerGraphTest {

    IntegerGraph integerGraph;

    @Before
    public void setUp() throws Exception {
        integerGraph = new IntegerGraph();
        integerGraph.addVertex(23);
        integerGraph.addVertex(56);
        integerGraph.addEdge(new DefaultEdge<>(23,56,false));
    }

    @After
    public void tearDown() throws Exception {
        showStatus("Finally");
    }

    @Test
    public void addVertex(){
        int size = integerGraph.getVerticesCount();
        integerGraph.addVertex(47);
        assertEquals(3,integerGraph.getVerticesCount());
    }

    private void showStatus(String string){
        System.out.printf("%s:%n%s", string, integerGraph);
    }

    @Test
    public void fullTest(){
        showStatus("In beginning");
        int sizeVertices = integerGraph.getVerticesCount();
        int sizeEdges = integerGraph.getEdgesCount();
        //addVertex
        assertTrue(integerGraph.addVertex(47));
        assertEquals(++sizeVertices,integerGraph.getVerticesCount());
        // addEdge
        assertFalse(integerGraph.addEdge(new DefaultEdge<>(54,23)));
        assertTrue(integerGraph.addEdge(new DefaultEdge<>(54,23),true));
        //isEdge
        assertTrue(integerGraph.isEdge(23,54));

    }
}