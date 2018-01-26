package com.github.olegik1719.trello.graph;

import java.util.Collection;

public interface Graph<T> {
    /**
     * Adding Vertices to Graph
     * @param vertex - new vertex for graph
     * @return true if it is added
     *         false if it isn't added
     */
    boolean addVertex(Vertex<T> vertex);

    /**
     * Check is this Vertex in Graph
     * @param vertex -- vertex for check
     * @return true if Graph include this vertex
     */
    boolean isVertex(Vertex<T> vertex);
    /**
     * Adding Edge
     * @param edge -- new Edge for graph
     * @return false is this edge was in graph yet
     */
    boolean addEdge(Edge<T> edge);

    boolean isEdge(Vertex<T> begin, Vertex<T> end);
    int getVerticesCount();
    int getEdgesCount();
    Collection<Vertex<T>> getNeighbours(Vertex<T> vertex);
    Collection<Edge<T>> getEdges();
    Collection<Vertex<T>> getVertices();

    Graph<T> copy(Graph<T> original);
}
