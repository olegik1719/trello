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
        //showStatus("In beginning");
        int sizeVertices = integerGraph.getVerticesCount();
        int sizeEdges = integerGraph.getEdgesCount();
        integerGraph.addVertex(47);
        //showStatus("Add one Vertex");
            assertEquals(++sizeVertices,integerGraph.getVerticesCount());
        System.out.printf("%s",integerGraph.addEdge(new DefaultEdge<>(54,23)));
        //showStatus("Try add one edge, no force");
            assertEquals(sizeEdges,integerGraph.getEdgesCount());
            assertEquals(sizeVertices,integerGraph.getVerticesCount());
        System.out.printf("%s",integerGraph.addEdge(new DefaultEdge<>(54,23),true));
        System.out.printf("%s",integerGraph.addEdge(new DefaultEdge<>(54,23)));
        //showStatus("Try add one edge, force");
        //    assertEquals(++sizeEdges,integerGraph.getEdgesCount());
        //    assertEquals(++sizeVertices,integerGraph.getVerticesCount());
    }
}