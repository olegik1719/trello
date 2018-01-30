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
        int vertex1 = 23;
        int vertex2 = 56;
        integerGraph.addVertex(vertex1);
        integerGraph.addVertex(vertex2);
        integerGraph.addEdge(new DefaultEdge<>(vertex1,vertex2,false));
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
    public void addEdge(){
        assertFalse(integerGraph.addEdge(new DefaultEdge<>(54,23)));
        assertFalse(integerGraph.isEdge(23,54));

        assertTrue(integerGraph.addEdge(new DefaultEdge<>(54,23),true));
        //isEdge
        assertTrue(integerGraph.isEdge(23,54));

        integerGraph.addEdge(new DefaultEdge<>(47,94,true,10), true);
        assertTrue(integerGraph.isEdge(47,94));
        assertFalse(integerGraph.isEdge(94,47));
        integerGraph.addEdge(new DefaultEdge<>(47,94,false,10), true);
        assertTrue(integerGraph.isEdge(47,94));
        assertTrue(integerGraph.isEdge(94,47));
        integerGraph.addEdge(new DefaultEdge<>(94,47,true,10), true);
    }

    @Test
    public void removeVertexEdge(){
        showStatus("In beginning");
        integerGraph.addVertex(47);
        integerGraph.addEdge(new DefaultEdge<>(54,23));
        integerGraph.isEdge(23,54);
        integerGraph.addEdge(new DefaultEdge<>(54,23),true);
        integerGraph.addEdge(new DefaultEdge<>(47,94,true,10), true);
        integerGraph.addEdge(new DefaultEdge<>(47,94,false,10), true);
        integerGraph.addEdge(new DefaultEdge<>(94,47,true,10), true);


        integerGraph.removeEdge(47,94, true);
        assertFalse(integerGraph.isEdge(47,94));

        integerGraph.removeVertex(23,true);
        for (int vertex:integerGraph.getVertices()){
            assertFalse(integerGraph.isEdge(23,vertex));
        }
    }
}